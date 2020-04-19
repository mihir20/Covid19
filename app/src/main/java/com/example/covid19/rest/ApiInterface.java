package com.example.covid19.rest;

import com.example.covid19.classes.ResourceResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("resources/resources.json")
    Call<ResourceResponse> getResources();
}
