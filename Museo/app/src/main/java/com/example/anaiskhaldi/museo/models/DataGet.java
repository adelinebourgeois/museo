package com.example.anaiskhaldi.museo.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Adeline on 12/07/2017.
 */

public class DataGet {

    public List<MuseumGetResults> results;

    @Override
    public String toString() {
        return "DataGet{" +
                "results=" + results +
                '}';
    }
}
