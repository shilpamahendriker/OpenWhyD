package com.example.openwhyd.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.openwhyd.R;
import com.example.openwhyd.adapter.TrackAdapter;
import com.example.openwhyd.model.Track;
import com.example.openwhyd.viewmodel.TrackViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private TrackViewModel trackViewModel;
    TrackAdapter trackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationViews();
        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);
        getTracks();

    }

    private void initializationViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    /* Retrieving data from the viewModel attaching to recycler view*/
    public void getTracks() {
        trackViewModel.getAllTracks().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(@Nullable List<Track> tList) {

                prepareRecyclerView(tList);
            }
        });

    }

    /*Setting up recycler view*/

    private void prepareRecyclerView(List<Track> tList) {

        trackAdapter = new TrackAdapter(this,tList);
        /*if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());*/
        mRecyclerView.setAdapter(trackAdapter);
        trackAdapter.notifyDataSetChanged();

    }


}
