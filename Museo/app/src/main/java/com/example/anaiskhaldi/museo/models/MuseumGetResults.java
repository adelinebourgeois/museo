package com.example.anaiskhaldi.museo.models;

import com.example.anaiskhaldi.museo.models.museum.MuseumGetGeometryData;

/**
 * Created by Adeline on 13/07/2017.
 */

class MuseumGetResults {

    public MuseumGetGeometryData geometry;
    public String name;
    public String vicinity;
    public String place_id;

    @Override
    public String toString() {
        return "MuseumGetResults{" +
                "geometry=" + geometry +
                ", name='" + name + '\'' +
                ", vicinity='" + vicinity + '\'' +
                ", place_id='" + place_id + '\'' +
                '}';
    }

    public MuseumGetGeometryData getGeometry() {
        return geometry;
    }

    public void setGeometry(MuseumGetGeometryData geometry) {
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }
}
