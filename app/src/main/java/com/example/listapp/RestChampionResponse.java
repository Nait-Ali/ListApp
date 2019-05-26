package com.example.listapp;

import java.util.List;

public class RestChampionResponse {
    private int key;
    private String next;
    private List<Champion> results;

    public int getKey() {
        return key;
    }

    public List<Champion> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }
}
