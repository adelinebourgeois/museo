package com.example.anaiskhaldi.museo.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Preference {

    private static final String PREF_LATITUDE = "lat";
    private static final String PREF_LONGITUDE = "lng";

    private static SharedPreferences get(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static float getLatitude(Context context) {
        return get(context).getFloat(PREF_LATITUDE, 0);
    }

    public static void setLatitude(Context context, float coordonnee) {
        get(context).edit().putFloat(PREF_LATITUDE, coordonnee).commit();
    }

    public static float getLongitude(Context context) {
        return get(context).getFloat(PREF_LONGITUDE, 0);
    }

    public static void setLongitude(Context context, float coordonnee) {
        get(context).edit().putFloat(PREF_LONGITUDE, coordonnee).commit();
    }

}
