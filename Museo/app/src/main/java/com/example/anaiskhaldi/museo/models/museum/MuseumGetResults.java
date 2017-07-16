package com.example.anaiskhaldi.museo.models.museum;

/**
 * Created by Adeline on 13/07/2017.
 */

public class MuseumGetResults {

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

}
