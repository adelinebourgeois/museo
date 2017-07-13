package com.example.anaiskhaldi.museo.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Adeline on 12/07/2017.
 */

public class MuseumGetGeometryData {

    public MuseumGetGeometryLocationData location;

    @Override
    public String toString() {
        return "MuseumGetGeometryData{" +
                "location=" + location +
                '}';
    }

    public MuseumGetGeometryLocationData getLocation() {
        return location;
    }

    public void setLocation(MuseumGetGeometryLocationData location) {
        this.location = location;
    }
}
