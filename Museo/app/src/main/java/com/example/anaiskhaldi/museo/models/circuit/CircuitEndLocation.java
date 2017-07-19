package com.example.anaiskhaldi.museo.models.circuit;

/**
 * Created by anaiskhaldi on 17/07/2017.
 */

public class CircuitEndLocation {

    public Float lat;
    public Float lng;

    @Override
    public String toString() {
        return "lat " + lat + '\'' +
                "lng " + lng;
    }
}
/*
 "end_location": {
        "lat": 48.8622999,
        "lng": 2.3366256
    },
 */