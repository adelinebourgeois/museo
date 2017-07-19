package com.example.anaiskhaldi.museo.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.anaiskhaldi.museo.ui.detail.DetailActivity;


public class Preference {

    private static final String PREF_SEARCH_LOCATION_COORDINATE = "coordinate";
    private static final String PREF_MUSEUM_LATITUDE = "lat";
    private static final String PREF_MUSEUM_LONGITUDE = "lng";
    private static final String PREF_MUSEUM_PLACE_ID = "name";
    private static final String PREF_MUSEUM_WEBSITE = "website";
    private static final String PREF_MUSEUM_PHONE = "phone";
    private static final String PREF_MUSEUM_PHOTO = "photo";

    private static final String PREF_LOCATION = "location";
    private static final String PREF_BACK = "false";

    private static SharedPreferences get(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    // BOOLEAN
    public static String getLocation(Context context) {
        return get(context).getString(PREF_LOCATION, null);
    }
    public static void setLocation(Context context, String location) {
        get(context).edit().putString(PREF_LOCATION, location).commit();
    }

    // BOOLEAN
    public static Boolean getBack(Context context) {
        return get(context).getBoolean(PREF_BACK, false);
    }
    public static void setBack(Context context, Boolean back) {
        get(context).edit().putBoolean(PREF_BACK, back).commit();
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

    public static String getWebsite(Context context){
        return get(context).getString(PREF_MUSEUM_WEBSITE, null);
    }

    public static void setWebsite(Context context, String website){
        get(context).edit().putString(PREF_MUSEUM_WEBSITE, website).commit();
    }

    public static String getPhone(Context context){
        return get(context).getString(PREF_MUSEUM_PHONE, null);
    }
    public static void setPhone(Context context, String phone){
        get(context).edit().putString(PREF_MUSEUM_PHONE, phone).commit();
    }

    public static String getPhoto(Context context){
        return get(context).getString(PREF_MUSEUM_PHOTO, null);
    }
    public static void setPhoto(Context context, String photo){
        get(context).edit().putString(PREF_MUSEUM_PHOTO, photo).commit();
    }
}
