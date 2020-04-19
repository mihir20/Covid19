package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.covid19.adapters.ResourcesAdapter;
import com.example.covid19.classes.Resource;
import com.example.covid19.classes.ResourceResponse;
import com.example.covid19.rest.ApiClient;
import com.example.covid19.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResourcesActivity extends AppCompatActivity {
    RecyclerView resRV;
    ArrayList<Resource> resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        resources=new ArrayList<>();
        intiViews();
        createList();
    }

    private void createList() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResourceResponse> call = apiService.getResources();
        call.enqueue(new Callback<ResourceResponse>() {
            @Override
            public void onResponse(Call<ResourceResponse> call, Response<ResourceResponse> response) {
                assert response.body() != null;
                resources= (ArrayList<Resource>) response.body().getResources();
                ResourcesAdapter adapter = new ResourcesAdapter(resources);
                resRV.setAdapter(adapter);
                resRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ResourceResponse> call, Throwable t) {
                Log.e("REST",t.toString());
            }
        });
    }

    private void intiViews() {
        resRV=findViewById(R.id.resoures_rv);
    }
}
