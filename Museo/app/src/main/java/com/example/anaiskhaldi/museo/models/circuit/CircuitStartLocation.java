package com.example.anaiskhaldi.museo.models.circuit;

/**
 * Created by anaiskhaldi on 17/07/2017.
 */

public class CircuitStartLocation {

    public Float lat;
    public Float lng;

    @Override
    public String toString() {
        return "lat " + lat + '\'' +
                "lng " + lng;
    }

}
/*
"start_location": {
        "lat": 48.862702,
        "lng": 2.3540632
    },
 */