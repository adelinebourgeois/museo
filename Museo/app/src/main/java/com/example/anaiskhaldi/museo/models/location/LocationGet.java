package com.example.anaiskhaldi.museo.models.location;

import java.util.List;

/**
 * Created by anaiskhaldi on 14/07/2017.
 */

public class LocationGet {

    public List<LocationResults> results;
    public String status;
    public String error_message;

}

/*

{
    "results": [
        {
            "address_components": [
                {
                    "long_name": "France",
                    "short_name": "FR",
                    "types": [
                        "country",
                        "political"
                    ]
                },
                {
                    "long_name": "Paris",
                    "short_name": "Paris",
                    "types": [
                        "locality",
                        "political"
                    ]
                },
                {
                    "long_name": "Paris",
                    "short_name": "Paris",
                    "types": [
                        "administrative_area_level_2",
                        "political"
                    ]
                },
                {
                    "long_name": "Île-de-France",
                    "short_name": "Île-de-France",
                    "types": [
                        "administrative_area_level_1",
                        "political"
                    ]
                },
                {
                    "long_name": "75003",
                    "short_name": "75003",
                    "types": [
                        "postal_code"
                    ]
                }
            ],
            "formatted_address": "75003 Paris, France",
            "geometry": {
                "location": {
                    "lat": 48.86263040000001,
                    "lng": 2.354028
                },
                "location_type": "GEOMETRIC_CENTER",
                "viewport": {
                    "northeast": {
                        "lat": 48.86397938029151,
                        "lng": 2.355376980291502
                    },
                    "southwest": {
                        "lat": 48.86128141970851,
                        "lng": 2.352679019708499
                    }
                }
            },
            "place_id": "ChIJuQQLcRtu5kcRxm3Fp8_TNaw",
            "types": [
                "establishment",
                "point_of_interest",
                "subway_station",
                "transit_station"
            ]
        }
    ],
    "status": "OK"
}

 */
