package com.example.listapp;

import android.net.Uri;

import java.io.Serializable;
import java.net.URI;

public class Champion implements Serializable {
    private String name;
    private String description;
    private String icon;
    private Statistiques stats;

    public Statistiques getStats() {
        return stats;
    }


    public String getIcon(){
        return icon;
    }
    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }
}
