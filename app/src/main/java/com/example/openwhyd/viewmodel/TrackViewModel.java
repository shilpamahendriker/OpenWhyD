package com.example.openwhyd.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.openwhyd.model.Track;
import com.example.openwhyd.model.TrackRepository;

import java.util.List;

public class TrackViewModel extends AndroidViewModel {

    private TrackRepository trackRepository;

    public TrackViewModel(@NonNull Application application) {
        super(application);
        trackRepository = new TrackRepository(application);
    }

    public LiveData<List<Track>> getAllTracks()
    {
        return trackRepository.getMutableLiveData();
    }
}
