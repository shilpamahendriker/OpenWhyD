package com.example.openwhyd.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.openwhyd.R;
import com.squareup.picasso.Picasso;



public class TrackDetailsActivity extends AppCompatActivity {

    String title = null;
    String userName = null;
    String imageURL ;
    String sourceURL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Track Details");

        /*Retrieve data from the intent*/
        Bundle extras = getIntent().getExtras();
        Intent intent = getIntent();
        imageURL = intent.getStringExtra("IMAGE_URL_PATH");
        if (extras != null){
            title = extras.getString("TITLE");
            userName = extras.getString("USERNAME");
            sourceURL = extras.getString("SOURCE_URL");
        }

        toolbar.setSubtitle(title);

        /* Settind data to the textviews to display track details*/
        ImageView imageView_track_image = findViewById(R.id.ivTrackImage);
        TextView textView_title = findViewById(R.id.tv_title);
        TextView textView_username = findViewById(R.id.tv_username);
        TextView textView_source_url = findViewById(R.id.tv_source);
        /*Picasso
                .get()
                .load(imageURL)
                .into(imageView_track_image);*/
        //Log.v("imageURL",imageURL);
        textView_title.setText(title);
        textView_username.setText("User Name:  " + userName);
        textView_source_url.setText("Source:  " + sourceURL);


    }

}
