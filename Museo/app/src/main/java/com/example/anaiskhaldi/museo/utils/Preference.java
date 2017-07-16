package com.example.anaiskhaldi.museo.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Preference {

    private static final String PREF_SEARCH_LOCATION_COORDINATE = "coordinate";
    private static final String PREF_MUSEUM_LATITUDE = "lat";
    private static final String PREF_MUSEUM_LONGITUDE = "lng";
    private static final String PREF_MUSEUM_PLACE_ID = "name";


    private static SharedPreferences get(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    // Getter and setter for the searched location
    public static String getSearchLocationCoordinate(Context context) {
        return get(context).getString(PREF_SEARCH_LOCATION_COORDINATE, null);
    }
    public static void setSearchLocationCoordinate(Context context, String coordinate) {
        get(context).edit().putString(PREF_SEARCH_LOCATION_COORDINATE, coordinate).commit();
    }

    // Getter and setter for coordinates of the museum
    public static float getLatitude(Context context) {
        return get(context).getFloat(PREF_MUSEUM_LATITUDE, 0);
    }
    public static void setLatitude(Context context, float latitude) {
        get(context).edit().putFloat(PREF_MUSEUM_LATITUDE, latitude).commit();
    }

    public static float getLongitude(Context context) {
        return get(context).getFloat(PREF_MUSEUM_LONGITUDE, 0);
    }
    public static void setLongitude(Context context, float longitude) {
        get(context).edit().putFloat(PREF_MUSEUM_LONGITUDE, longitude).commit();
    }

    public static String getMuseumPlaceId(Context context){
        return get(context).getString(PREF_MUSEUM_PLACE_ID, null);
    }
    public static void setMuseumPlaceId(Context context, String placeId){
        get(context).edit().putString(PREF_MUSEUM_PLACE_ID, placeId).commit();
    }

}
