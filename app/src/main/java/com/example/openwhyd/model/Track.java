package com.example.openwhyd.model;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* POJO Class for the JSON to be retrieved from the OpenWhyD api
* */
public class Track {
    @SerializedName("name")
    @Expose
    private String title;
    @SerializedName("uNm")
    @Expose
    private  String user_name;

    @SerializedName("img")
    @Expose
    private String image_url;
    @SerializedName("eId")
    @Expose
    private String source_url;

    public String getTitle() {
        return title;
    }
    public String getUser_name(){
        return user_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSource_url() {
        return source_url;
    }
}
