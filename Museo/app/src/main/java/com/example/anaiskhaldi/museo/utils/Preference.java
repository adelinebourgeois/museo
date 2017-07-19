package com.example.anaiskhaldi.museo.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.anaiskhaldi.museo.ui.detail.DetailActivity;


public class Preference {

    private static final String PREF_SEARCH_LOCATION_COORDINATE = "coordinate";

    private static final String PREF_LOCATION = "location";

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


    // Getter and setter for the searched location
    public static String getSearchLocationCoordinate(Context context) {
        return get(context).getString(PREF_SEARCH_LOCATION_COORDINATE, null);
    }
    public static void setSearchLocationCoordinate(Context context, String coordinate) {
        get(context).edit().putString(PREF_SEARCH_LOCATION_COORDINATE, coordinate).commit();
    }


}
