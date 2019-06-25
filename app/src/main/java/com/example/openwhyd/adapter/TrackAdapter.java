package com.example.openwhyd.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.openwhyd.R;
import com.example.openwhyd.model.Track;
import com.example.openwhyd.views.TrackDetailsActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder>{



    //this context used to inflate the layout
    private Context context;

    //storing all the Locations in a list
    private List<Track> Tracks;

    //getting the context and Locations list with constructor
    public TrackAdapter(Context context, List<Track> Tracks) {

        this.context = context;
        this.Tracks = Tracks;

    }

    @NonNull
    @Override
    public TrackAdapter.TrackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning the view holder

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.recycler_view_inner_layout, viewGroup,false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder trackViewHolder,  final int i) {


        //getting the location of the specified position

        final Track Track = Tracks.get(i);

        //binding the data with the view holder views
        trackViewHolder.textTrackName.setText(Track.getTitle());
        String imageUriPath = Track.getImage_url();
        Log.v("imageURI",imageUriPath);



        Picasso
                .get()
                .load(imageUriPath)
                .into(trackViewHolder.ivTrackImage);

        //Creating on click listener for the item selected on the view holder
        trackViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Track selection = Tracks.get(i);

                // Sending image url, username and track name through the intent to track details activity
                Intent intent = new Intent(context, TrackDetailsActivity.class);
                intent.putExtra("TITLE", selection.getTitle());
                intent.putExtra("USERNAME", selection.getUser_name());
                //intent.putExtra("REPOST_USERNAME",selection.getTracksArrayList().get(i).getRepost_user_name());
                intent.putExtra("IMAGEURL", selection.getImage_url());
                Log.v("selection", selection.getImage_url());
                intent.putExtra("SOURCE_URL",selection.getSource_url());
                Intent imageIntent = new Intent(context, TrackDetailsActivity.class);
                imageIntent.putExtra("IMAGE_URL_PATH", selection.getImage_url());
                context.startActivity(intent);


            }
        });
    }




    @Override
    public int getItemCount() {
        return Tracks.size();
    }



    class TrackViewHolder extends RecyclerView.ViewHolder {
        TextView textTrackName;
        ImageView ivTrackImage;


        /*constructor that accepts the entire item row and lookups to find each subview*/

        public TrackViewHolder(View itemView) {
            super(itemView);
            textTrackName = itemView.findViewById(R.id.txtTrackTitle);
            ivTrackImage = itemView.findViewById(R.id.ivTrackImage);


        }
    }
}
