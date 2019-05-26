package com.example.listapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    private static RestApiChampionLol restApiChampionLol;

    //Singleton
    public static RestApiChampionLol getRestApi(){
        if(restApiChampionLol == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/ngryman/lol-champions/master/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiChampionLol = retrofit.create(RestApiChampionLol.class);
        }
        return restApiChampionLol;
    }
}