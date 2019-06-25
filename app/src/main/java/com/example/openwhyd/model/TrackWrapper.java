package com.example.openwhyd.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackWrapper {

    /* POJO Class for the JSON to be retrieved from the OpenWhyD api
     * */
    HasMore HasMoreObject;

    @SerializedName("tracks")
    @Expose
    private List<Track> trackList;

    /*@SerializedName("hasMore")
    @Expose
    private String hasmore;*/

    @SerializedName("genre")
    @Expose
    private String genre;

    public List<Track> getTrackList() {
        return trackList;
    }

   /* public String getHasmore() {
        return hasmore;
    }*/



        public String getGenre() {
        return genre;
    }
    public class HasMore {
        private float skip;


        // Getter Methods

        public float getSkip() {
            return skip;
        }

        // Setter Methods

        public void setSkip( float skip ) {
            this.skip = skip;
        }
    }
}
