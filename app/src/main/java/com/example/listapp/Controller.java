package com.example.listapp;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    private final MainActivity mainActivity;
    private RestApiChampionLol restApiChampionLol;

    public Controller(MainActivity mainActivity, RestApiChampionLol restApiChampionLol) {
        this.mainActivity = mainActivity;
        this.restApiChampionLol = restApiChampionLol;
    }


    public void onCreate() {
        Call<List<Champion>> call = restApiChampionLol.getChampionData();
        call.enqueue(new Callback<List<Champion>>() {
            @Override
            public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                List<Champion> championList = response.body();
                mainActivity.showList(championList);
            }

            @Override
            public void onFailure(Call<List<Champion>> call, Throwable t) {

            }
        });
    }


















   /* public void downloadData() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestApiChampionLol restApiChampionLol = retrofit.create(RestApiChampionLol.class);
        Call<List<RestChampionResponse>> call = restApiChampionLol.getChampionData();
        call.enqueue(new Callback<List<RestChampionResponse>>() {
            @Override
            public void onResponse(Call<List<RestChampionResponse>> call, Response<List<RestChampionResponse>> response) {
                if (response.isSuccessful()) {
                    List<RestChampionResponse> changesList = response.body();
                    //changesList.forEach(change -> System.out.println(change.subject));
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<RestChampionResponse>> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }*/
}
