package com.example.anaiskhaldi.museo.models.detail;

import java.util.List;

/**
 * Created by anaiskhaldi on 15/07/2017.
 */

public class DetailResult {

    public String formatted_address;
    public String formatted_phone_number;
    public DetailGeometry geometry;
    public String name;
    public DetailOpeningHours opening_hours;
    public Float rating;
    public List<DetailReviews> reviews;
    public String website;


        /*

    "result": {
        "address_components": [
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
                "long_name": "France",
                "short_name": "FR",
                "types": [
                    "country",
                    "political"
                ]
            },
            {
                "long_name": "75004",
                "short_name": "75004",
                "types": [
                    "postal_code"
                ]
            }
        ],
        "adr_address": "Place Georges-Pompidou, <span class=\"postal-code\">75004</span> <span class=\"locality\">Paris</span>, <span class=\"country-name\">France</span>",
        "formatted_address": "Place Georges-Pompidou, 75004 Paris, France",
        "formatted_phone_number": "01 44 78 12 33",
        "geometry": {
            "location": {
                "lat": 48.86064200000001,
                "lng": 2.352245
            },
            "viewport": {
                "northeast": {
                    "lat": 48.86193895000001,
                    "lng": 2.3541162
                },
                "southwest": {
                    "lat": 48.85891794999998,
                    "lng": 2.3513682
                }
            }
        },
        "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/museum-71.png",
        "id": "8546df4461a8d783d8452ed7272edbee05a591b0",
        "international_phone_number": "+33 1 44 78 12 33",
        "name": "Le Centre Pompidou",
        "opening_hours": {
            "open_now": true,
            "periods": [
                {
                    "close": {
                        "day": 0,
                        "time": "2200"
                    },
                    "open": {
                        "day": 0,
                        "time": "1100"
                    }
                },
                {
                    "close": {
                        "day": 1,
                        "time": "2200"
                    },
                    "open": {
                        "day": 1,
                        "time": "1100"
                    }
                },
                {
                    "close": {
                        "day": 3,
                        "time": "2200"
                    },
                    "open": {
                        "day": 3,
                        "time": "1100"
                    }
                },
                {
                    "close": {
                        "day": 4,
                        "time": "2200"
                    },
                    "open": {
                        "day": 4,
                        "time": "1100"
                    }
                },
                {
                    "close": {
                        "day": 5,
                        "time": "2200"
                    },
                    "open": {
                        "day": 5,
                        "time": "1100"
                    }
                },
                {
                    "close": {
                        "day": 6,
                        "time": "2200"
                    },
                    "open": {
                        "day": 6,
                        "time": "1100"
                    }
                }
            ],
            "weekday_text": [
                "lundi: 11:00 – 22:00",
                "mardi: Fermé",
                "mercredi: 11:00 – 22:00",
                "jeudi: 11:00 – 22:00",
                "vendredi: 11:00 – 22:00",
                "samedi: 11:00 – 22:00",
                "dimanche: 11:00 – 22:00"
            ]
        },
        "photos": [
            {
                "height": 2322,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/114280183344710579838/photos\">Elisabeth COUTROT</a>"
                ],
                "photo_reference": "CmRaAAAApUaONhbXCCHNUbC14bHx5ITSrCSPfldKiSe7ATivsIN8-egQrVq4jX9bk3P_YHlJ_napeFVIzqXhoKunWdp0ku8cFbhIRJ4kuaCrP53xSsBjxV7SmeIEUtEWaaYLqcmjEhCLzDBXuPkXwfS11NXjJQ_-GhTtkmn8qi_ho4tSll9B3FXVdFQUjw",
                "width": 4128
            },
            {
                "height": 1920,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/107967676893733351472/photos\">Isabelle Piron</a>"
                ],
                "photo_reference": "CmRaAAAAYEMDY1BLrY550KPysu5P5bq3TMV7-kpbBSUaJn6di96NlKTrCrzoTRJ1IF6jOjgk2GGYOt6yIPJuM-saIOauh7UyZQxQeGtdNAQQCeGFCqzHwhKW-zgQTGD44zIAyUAKEhCFc-TUQb3qP_6ceX7Lp7c_GhRsBUIvRlcu3-EOdUTKk8v6t7PZ9w",
                "width": 2560
            },
            {
                "height": 3672,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/108827327780856943546/photos\">Mickael HAMELIN</a>"
                ],
                "photo_reference": "CmRaAAAAMv3_jlf0xoIXGMQlowK4OGjmrTJxTqrZMVTJtDQHqLQ9_Vh-5hBNSZEiV_3PGAqPnMBIqFMFepIh3y9m95RmmVXmXrQvAxYfr3Tg0keVG01Tz7onJ5t_6YjJXj42p5O5EhAWz2uzSg4nC7V86oNQvBTZGhRVjARmnm_Z3jIdBSF8oewXv6wk6g",
                "width": 4896
            },
            {
                "height": 2268,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/108802868999125345703/photos\">Ben Bethel</a>"
                ],
                "photo_reference": "CmRaAAAA9jRJuLu8U1HNFiJi8DZ5UQIoYdIAjJgxtAJIyYOePqm_9VR10d_y4Od-e0AtZ9CSCUhjazIv5zoe7vNorfN2INhPnY-Q-YJi4YnbFl2Kyvef_5sIIDi_rX9MPvIivJGvEhBXtMvXMHWCt1UVwFzn0CUNGhRxmpeBhELWCuyYQ1jSUV0E6gEswQ",
                "width": 4032
            },
            {
                "height": 2448,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/108343742756806094110/photos\">Jakob Christ</a>"
                ],
                "photo_reference": "CmRaAAAAaJouknJ8xZaTgQkVcWvLEt6wAkbWg9552LgL5E-NPjquJN3bJOayPrTGzvj7XHssOoFkSD8mquKAT9a4RsQwB2wb4KLHGgNlc2jgpCL_ijTNy7QntC_yWczq1FkDWoLqEhBU-sCR-ljXS26fcEf7hAnWGhQs73ho9CbxssLrpJPhPk8Jj49cDA",
                "width": 3264
            },
            {
                "height": 2268,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/108802868999125345703/photos\">Ben Bethel</a>"
                ],
                "photo_reference": "CmRaAAAA9eE7ebwtEafPAsA4APiSSs5oS-Uz17kiWF3TaPJMymgv70eh8ccEPsI3dOFelN0doDjLffAckVv8jSticjPSgyiWzO-K_D4clHGCVb7-BnPXWMYxg9P84DeaUgKE757HEhCMRBvbrIEb1YbknmpJHfk7GhRcq2B-dPqo6dMac0vdWXw0OPv4SA",
                "width": 4032
            },
            {
                "height": 1071,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/111184284122214829645/photos\">林鳳聲</a>"
                ],
                "photo_reference": "CmRaAAAAcYCIdSpvJkXTW1t2zAxQcA4bNIOa-12NQoCkmt4D76Jig32Y6BLpZdI__OV1E-lyKW-aY5n9HsRdfNhO_0Ohktony8NzBfNfjOyLfgHEYaenGwyoF-Z4tZOm1zUv7SKLEhBss3IEJKJLPM0vROQmHAWTGhTfLTJHEJp6AnvVvySBEQtQmMQDYg",
                "width": 1600
            },
            {
                "height": 600,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/101923881526042540438/photos\">Nermin Abdullayeva</a>"
                ],
                "photo_reference": "CmRaAAAAi1IsQ-y9brZlhx6tlc7pjJ7Nr3_jPGxhOWqK_pBrB9w30hyijZ7fnVDPpz8ao2cZvqf87pvnG54J2NK4Rj81En5lKH_LuIs6KeEijWbFhKro8-epJGMpBWI6umK1oOtvEhAKgS3S6fMVRFL0qRu9S6D2GhTBey5qvYKgFAcO0EmKgDba61WCsg",
                "width": 960
            },
            {
                "height": 1836,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/115909259217739877366/photos\">Robin Csontos</a>"
                ],
                "photo_reference": "CmRaAAAAMmMaHSOWqblL9eXFecmmeWdTIFmOM8aqrm5J4U_5BqYfcUpz9OuJN60b1ocmMHGiKF4psYcUMPuFaowYO8142iD2Db8CecPe5vwCIkL-GsUiOT07krvrT9jU8mYfgrAOEhBODGd7ZvoT_uXU98Oa0Jk9GhQhrmPutLFg3Y4NbGWyLPha6DSm2Q",
                "width": 3264
            },
            {
                "height": 1536,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/103690555393604569922/photos\">Michael Atlan</a>"
                ],
                "photo_reference": "CmRaAAAA58A9Tj1TKtJ2VORl0owR0skuu6kbbDl9dQZistsJI2ylDcvbZg-tNkHdGuPTJh_ZtMZz2-Sgonu2675I4j6FhKxI9YanZvV24oNqN0XXc-KeD8datHJ6oDq1wH1vvOx6EhCRUxOrI5YpQfsHAavb8cfzGhTvdn5cv59EnhdSiuhJnfFMOYvBig",
                "width": 2048
            }
        ],
        "place_id": "ChIJoyC4CRxu5kcRRTPcWX5srLc",
        "rating": 4.2,
        "reference": "CmRSAAAAqqeSls2OOKq6vwZyOnq6ZkxndLO2oQt-RV8rkWVRddB5rAWWmSUjouOwgbPGOwX4bNVxx0j11jFGdjrEkmXMHSacKE5LmaNm37aQI4oyjbCvoqZ-rMHyJT94PCWMicwLEhCakcjvscdej0h_CN6QJwhWGhREa44Avf-288Ptl0tK7EPxJhl2ng",
        "reviews": [
            {
                "author_name": "Busity - Guide de Paris mobile",
                "author_url": "https://www.google.com/maps/contrib/103980295702337146289/reviews",
                "language": "fr",
                "profile_photo_url": "https://lh6.googleusercontent.com/-KtxR9dUfbtk/AAAAAAAAAAI/AAAAAAAAAB4/5XyGib5sX9Q/s128-c0x00000000-cc-rp-mo-ba4/photo.jpg",
                "rating": 4,
                "relative_time_description": "il y a 2 mois",
                "text": "« Notre-Dame de la Tuyauterie » 🚽, « usine à gaz » 🏭, ou encore « verrue d’avant-garde », le pauvre Centre Pompidou a reçu des surnoms de toutes les couleurs. Dur pour le lieu qui possède la troisième plus importante collection d'art moderne avec plus de 100.000 œuvres.  Tout ce qui est normalement dissimulé (canalisations, escaliers électriques et passerelles métalliques) est ici ostensiblement montré. Et j'aime ça ! Si le contemporain ce n'est pas votre truc, contentez vous de la vue panoramique sur le centre de Paris, pour 3€ !",
                "time": 1494341157
            },
            {
                "author_name": "Isabel Alfonzo",
                "author_url": "https://www.google.com/maps/contrib/117856165912110263715/reviews",
                "language": "fr",
                "profile_photo_url": "https://lh3.googleusercontent.com/-U5y6ETbpa38/AAAAAAAAAAI/AAAAAAAAD_Y/EDc--JvsuPM/s128-c0x00000000-cc-rp-mo-ba4/photo.jpg",
                "rating": 4,
                "relative_time_description": "au cours de la dernière semaine",
                "text": "Le musée: magnifique. Belle collection permanente!\nSeul hic: sans audioguide, vous ne savez pas vraiment quel est l'ordre conseillé pour la visite de chaque étage\n\nUne autre chose: les gardiens ne font vraiment rien pour ne pas alimenter le cliché des français qui ne parlent pas d'autre langue et qui ne sont pas gentils avec les touristes",
                "time": 1499620621
            },
            {
                "author_name": "Jeanluc Coudun",
                "author_url": "https://www.google.com/maps/contrib/114555768165723408332/reviews",
                "language": "fr",
                "profile_photo_url": "https://lh4.googleusercontent.com/-SjAOtcqwrr8/AAAAAAAAAAI/AAAAAAAAAAA/AI6yGXy9EGdCpb0W715_AXz3wwqRvbLq1w/s128-c0x00000000-cc-rp-mo/photo.jpg",
                "rating": 1,
                "relative_time_description": "il y a une semaine",
                "text": "Abonné, j'avais oublié ma carte. Je suis allé au bureau des abonnés. Ils ont reconnu que j'étais abonné. Ils m'ont quand même fait payer 12€ pour rentrer ! Bienvenu au club des abonnés !",
                "time": 1499410475
            },
            {
                "author_name": "Delfina Oc",
                "author_url": "https://www.google.com/maps/contrib/107114900321850673300/reviews",
                "language": "fr",
                "profile_photo_url": "https://lh4.googleusercontent.com/-jfKubPD-vnw/AAAAAAAAAAI/AAAAAAAADQE/bfr4RmoNmd4/s128-c0x00000000-cc-rp-mo-ba2/photo.jpg",
                "rating": 5,
                "relative_time_description": "au cours de la dernière semaine",
                "text": "Excellent musée, expositions super intéressantes et bien réalisés/curés. Bâtiment impressionnant, en plus d'avoir une bibliothèque et filmothèque au top. À pas rater ",
                "time": 1499684410
            },
            {
                "author_name": "Pierre Boiteau",
                "author_url": "https://www.google.com/maps/contrib/102985626341674164440/reviews",
                "language": "fr",
                "profile_photo_url": "https://lh3.googleusercontent.com/-p56gpsoDOQk/AAAAAAAAAAI/AAAAAAAAAU8/SpYTyyla5fg/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg",
                "rating": 4,
                "relative_time_description": "il y a une semaine",
                "text": "Les visites du centre lui-même n'ont que peu d'intérêt à mon goût... sauf parfois certaines expositions temporaires. Mais il faut l'avoir vu au moins une fois de l'extérieur. Et surtout prendre le temps de profiter de l'ambiance sur l'esplanade.",
                "time": 1498991440
            }
        ],
        "scope": "GOOGLE",
        "types": [
            "museum",
            "point_of_interest",
            "establishment"
        ],
        "url": "https://maps.google.com/?cid=13235072694864327493",
        "utc_offset": 120,
        "vicinity": "Place Georges-Pompidou, Paris",
        "website": "http://www.centrepompidou.fr/"
    },
    "status": "OK"

    */


}
