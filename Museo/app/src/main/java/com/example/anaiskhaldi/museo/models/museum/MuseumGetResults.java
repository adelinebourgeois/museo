package com.example.anaiskhaldi.museo.models.museum;

import java.util.List;

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

    /*
     {
            "geometry": {
                "location": {
                    "lat": 48.8606111,
                    "lng": 2.337644
                },
                "viewport": {
                    "northeast": {
                        "lat": 48.86313575,
                        "lng": 2.3391953
                    },
                    "southwest": {
                        "lat": 48.85976955,
                        "lng": 2.3329901
                    }
                }
            },
            "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/museum-71.png",
            "id": "9a007d81ca8f47ed30ddaf39c4174ef773b351e0",
            "name": "Musée du Louvre",
            "opening_hours": {
                "open_now": true,
                "weekday_text": []
            },
            "photos": [
                {
                    "height": 2848,
                    "html_attributions": [
                        "<a href=\"https://maps.google.com/maps/contrib/109983477559905217030/photos\">Christophe Jacquet</a>"
                    ],
                    "photo_reference": "CmRaAAAA1vYlejLfVcLTqoMdoLvVtV58vA7VwoK-Te7R85I1p-eZUqRrMLYswtvrm5cK6N7f1wx6TsxG5daQUShJ4ZawQPArIxdX_aoXVauVQEB2AG31eANgt1auBHQHTsJanXO6EhCRkKFyp9AOooZidb7TiuqzGhTjVxgUrLFjquiXtHTUK9rCNrztsQ",
                    "width": 4288
                }
            ],
            "place_id": "ChIJD3uTd9hx5kcR1IQvGfr8dbk",
            "price_level": 2,
            "rating": 4.6,
            "reference": "CmRSAAAAuW1aSFreyJQ6YF3Btx9Lw0zGsPBN748YEpmG0QOpa_4s46MZMkWz_1uHZaIRb1hSSmkmt41ZHS8wMrWkdhZQpGa7JSBYTGEobMKAhV7Z0ItsO8K9G2-0kIH3FSbtAJn1EhDdU0yo8M5dTBKWEec_54GCGhQ28bEWvjilrMKkzGUcWzrga7WHFQ",
            "scope": "GOOGLE",
            "types": [
                "museum",
                "point_of_interest",
                "establishment"
            ],
            "vicinity": "Rue de Rivoli, Paris"
        },
     */
}
