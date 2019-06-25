package com.example.openwhyd.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.openwhyd.service.RestApiService;
import com.example.openwhyd.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackRepository {

    private ArrayList<Track> tracks = new ArrayList<>();
    private MutableLiveData<List<Track>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public TrackRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Track>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<TrackWrapper> call = apiService.getTracks();



        call.enqueue(new Callback<TrackWrapper>() {
            @Override
            public void onResponse(Call<TrackWrapper> call, Response<TrackWrapper> response) {
                TrackWrapper trackWrapper = response.body();
                if (trackWrapper != null) {
                    tracks = (ArrayList<Track>) trackWrapper.getTrackList();
                    mutableLiveData.setValue(tracks);
                }
            }

            @Override
            public void onFailure(Call<TrackWrapper> call, Throwable t) {
                call.clone().enqueue(this);
                Log.e("error in SplashScreen", "!!" + t.getMessage());


                Log.v("Nodata","No data retrived");

            }
        });


        return mutableLiveData;
    }
}
