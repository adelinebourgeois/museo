package com.example.anaiskhaldi.museo.models;

/**
 * Created by Adeline on 13/07/2017.
 */

public class MuseumGetGeometryLocationData {

    public String lat;
    public String lng;

    @Override
    public String toString() {
        return "MuseumGetGeometryLocationData{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
