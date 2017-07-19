package com.example.anaiskhaldi.museo.utils;

/**
 * Created by anaiskhaldi on 13/07/2017.
 */

public class Constant {

    // Splash Screen
    public static final long SPLASH_TIME = 2000;

    // API KEY
    public static final String API_KEY_DIRECTION = "AIzaSyAkQpSoWBGmp2BdwHTpCR4UME1AMo05b2M";
    public static final String API_KEY_GEOCODING = "AIzaSyBMf6E3QovzQx4L6IgRA3Q7CvXFiItnKAA";
    public static final String API_KEY_PLACES = "AIzaSyA39UHu2BMJpJ4cz5xJSUv_eUr9ce8-2IY";

    public static final String URL_GET_COORDONNATE = "https://maps.googleapis.com/maps/api/geocode/json?address=%s&region=fr&key=" + API_KEY_GEOCODING;
    public static final String URL_GET_MUSEUM = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s&radius=500&type=museum&key=" + API_KEY_PLACES;
    public static final String URL_GET_MUSEUM_DETAIL = "https://maps.googleapis.com/maps/api/place/details/json?placeid=%s&language=fr&key=" + API_KEY_PLACES;
    public static final String URL_GET_CIRCUIT = "https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=place_id:%s&mode=walking&language=fr&key=" + API_KEY_DIRECTION;

    public static final String URL_GET_MUSEUM_PHOTO = "https://maps.googleapis.com/maps/api/place/photo?photoreference=%s&maxwidth=600&maxheight=700&key=" + API_KEY_PLACES;

}
