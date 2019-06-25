package com.example.openwhyd.service;

import com.example.openwhyd.model.Track;
import com.example.openwhyd.model.TrackWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {

    String BASE_URL = "https://openwhyd.org/";

    // endpoint to retrieve arraylist for loading in the recyclerview in main activity
    @GET("hot?format=json&limit=100")
    Call<TrackWrapper> getTracks();
}
