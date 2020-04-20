package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.covid19.classes.TravelHistory;
import com.example.covid19.classes.TravelHistoryResponse;
import com.example.covid19.rest.ApiClient;
import com.example.covid19.rest.ApiInterface;

import java.text.ParseException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotspotActivity extends AppCompatActivity implements LocationListener {
    protected LocationManager locationManager;
    private ArrayList<TravelHistory> mTravelHistories;
    private TextView mNearestHotspotTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
        intiViews();
        findHotspots();
    }

    private void intiViews() {
        mNearestHotspotTV = findViewById(R.id.nearest_hotspot_tv);
    }

    private void findHotspots() {
        mTravelHistories = new ArrayList<>();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TravelHistoryResponse> call = apiService.getTravelHistory();
        call.enqueue(new Callback<TravelHistoryResponse>() {
            @Override
            public void onResponse(Call<TravelHistoryResponse> call, Response<TravelHistoryResponse> response) {
                mTravelHistories = (ArrayList<TravelHistory>) response.body().getTravelHistory();
                Log.e("TRAVEL HISTORY", mTravelHistories.get(0).getLatlong());
            }

            @Override
            public void onFailure(Call<TravelHistoryResponse> call, Throwable t) {
                Log.e("TRAVEL HISTORY", t.toString());
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        if (mTravelHistories.size()!=0){
            Log.e("LOACTION",location.toString());

            try {
                findNearestHotspot(location);
            } catch (ParseException e) {
                Log.e("PARSE",e.getMessage());
            }
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("LOCATION",provider);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("LOCATION",provider+" enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("LOCATION",provider+" disabled");
    }

    private void findNearestHotspot(Location a) throws ParseException {
        double minDistace=Double.MAX_VALUE;
        int minIndex=0;
        Location b=new Location("B");
        for(int i=0;i<mTravelHistories.size();i++){
           String[] latLongArr = mTravelHistories.get(i).getLatlong().split(",");
           if(latLongArr.length==2){
               b.setLatitude(Double.parseDouble(latLongArr[0]));
               b.setLongitude(Double.parseDouble(latLongArr[1]));
               double dist  = b.distanceTo(a);
               if(dist<minDistace){
                   minDistace=dist;
                   minIndex=i;
               }
           }
        }
        mNearestHotspotTV.setText("Nearest Corona Hotspot is at "+ mTravelHistories.get(minIndex).getAddress()+ ". which is "+Math.floor(minDistace/1000)+" KM from you.");
    }
}
