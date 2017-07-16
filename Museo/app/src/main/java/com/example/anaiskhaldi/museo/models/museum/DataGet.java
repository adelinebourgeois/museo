package com.example.anaiskhaldi.museo.models.museum;

import java.util.List;

/**
 * Created by Adeline on 12/07/2017.
 */

public class DataGet {

    public List<MuseumGetResults> results;
    public String status;
    public String error_message;

    @Override
    public String toString() {
        return "DataGet{" +
                "results=" + results + '\'' +
                ", status='" + status + '\'' +
                ", error_message='" + error_message + '\'' +
                '}';
    }
}
