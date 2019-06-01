package com.example.listapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApiChampionLol {
    @GET("champions.json")
    Call<RestChampionResponse> getChampionData();
}
