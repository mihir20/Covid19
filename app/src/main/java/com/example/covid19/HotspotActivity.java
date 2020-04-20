package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.covid19.classes.TravelHistory;
import com.example.covid19.classes.TravelHistoryResponse;
import com.example.covid19.rest.ApiClient;
import com.example.covid19.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotspotActivity extends AppCompatActivity {
    private ArrayList<TravelHistory> mTravelHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot);
        findHotspots();
    }

    private void findHotspots() {
        mTravelHistory = new ArrayList<>();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TravelHistoryResponse> call = apiService.getTravelHistory();
        call.enqueue(new Callback<TravelHistoryResponse>() {
            @Override
            public void onResponse(Call<TravelHistoryResponse> call, Response<TravelHistoryResponse> response) {
                mTravelHistory = (ArrayList<TravelHistory>) response.body().getTravelHistory();
                Log.e("TRAVEL HISTORY",mTravelHistory.get(0).getAddress());
            }

            @Override
            public void onFailure(Call<TravelHistoryResponse> call, Throwable t) {
                Log.e("TRAVEL HISTORY",t.toString());
            }
        });
    }
}
