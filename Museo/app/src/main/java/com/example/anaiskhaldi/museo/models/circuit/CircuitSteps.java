package com.example.anaiskhaldi.museo.models.circuit;

/**
 * Created by anaiskhaldi on 17/07/2017.
 */

public class CircuitSteps {

    public CircuitDistance distance;
    public CircuitDuration duration;
    public CircuitEndLocation end_location;
    public String html_instructions;
    public CircuitPolyline polyline;
    public CircuitStartLocation start_location;
    public String travel_mode;

    @Override
    public String toString() {
        return "distance "+ distance +
                " duration " + duration +
                " end_location " + end_location +
                " html_instructions " + html_instructions +
                " polyline " + polyline +
                " start_location " + start_location +
                " travel_mode " + travel_mode;
    }
}



/*
"steps": [
        {
            "distance": {
                "text": "14 m",
                "value": 14
            },
            "duration": {
                "text": "1 minute",
                "value": 4
            },
            "end_location": {
                "lat": 48.8626647,
                "lng": 2.3542498
            },
            "html_instructions": "Prendre la direction <b>est</b> sur <b>Rue du Grenier-Saint-Lazare</b> vers <b>Rue Beaubourg</b>",
            "polyline": {
                "points": "{nfiH{wjMBQBS"
            },
            "start_location": {
                "lat": 48.862702,
                "lng": 2.3540632
            },
            "travel_mode": "DRIVING"
        },
        {
            "distance": {
                "text": "0,3 km",
                "value": 277
            },
            "duration": {
                "text": "1 minute",
                "value": 69
            },
            "end_location": {
                "lat": 48.8603229,
                "lng": 2.3529662
            },
            "html_instructions": "Prendre <b>à droite</b> sur <b>Rue Beaubourg</b>",
            "maneuver": "turn-right",
            "polyline": {
                "points": "snfiHayjM|BdAr@Zz@^n@ZJDx@^nBz@"
            },
            "start_location": {
                "lat": 48.8626647,
                "lng": 2.3542498
            },
            "travel_mode": "DRIVING"
        },
        {
            "distance": {
                "text": "0,3 km",
                "value": 332
            },
            "duration": {
                "text": "1 minute",
                "value": 68
            },
            "end_location": {
                "lat": 48.8575022,
                "lng": 2.3514621
            },
            "html_instructions": "Continuer sur <b>Rue du Renard</b>",
            "polyline": {
                "points": "_`fiHaqjMrAl@z@^@@PHNHp@Zj@Rt@V|@`@dBx@fAd@"
            },
            "start_location": {
                "lat": 48.8603229,
                "lng": 2.3529662
            },
            "travel_mode": "DRIVING"
        },
        {
            "distance": {
                "text": "1,2 km",
                "value": 1210
            },
            "duration": {
                "text": "5 minutes",
                "value": 294
            },
            "end_location": {
                "lat": 48.8622999,
                "lng": 2.3366256
            },
            "html_instructions": "Prendre <b>à droite</b> sur <b>Rue de Rivoli</b>",
            "maneuver": "turn-right",
            "polyline": {
                "points": "kneiHsgjMMh@}@pEc@nBc@lBo@rCGR]|AI`@Id@cAhEo@rC]~AWlAu@`Di@pB_ArEQv@y@lDYjAS|@Sv@YpAm@lCiCbLWlA"
            },
            "start_location": {
                "lat": 48.8575022,
                "lng": 2.3514621
            },
            "travel_mode": "DRIVING"
        }
    ],
 */
