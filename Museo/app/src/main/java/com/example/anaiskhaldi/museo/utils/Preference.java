package com.example.anaiskhaldi.museo.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Preference {

    private static final String PREF_COORDINATE = "coordonnee";

    private static SharedPreferences get(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    /*public static int[] getCoordonnee(Context context) {
        //return get(context).get(PREF_COORDINATE, 0);
    }

    public static void setCoordonnee(Context context, int[] coordonnee) {
        get(context).edit().putInt(PREF_COORDINATE, coordonnee).commit();
    }*/

}
