package com.example.listapp;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Controller {

    private final MainActivity mainActivity;
    private RestApiChampionLol restApiChampionLol;

    public Controller(MainActivity mainActivity, RestApiChampionLol restApiChampionLol) {
        this.mainActivity = mainActivity;
        this.restApiChampionLol = restApiChampionLol;
    }


    public void onCreate() {
        Call<RestChampionResponse> call = restApiChampionLol.getChampionData();
        call.enqueue(new Callback<RestChampionResponse>() {
            @Override
            public void onResponse(Call<RestChampionResponse> call, Response<RestChampionResponse> response) {
                if (response.isSuccessful()) {
                    RestChampionResponse restApiChampionLol = response.body();
                    List<Champion> championList = restApiChampionLol.getResults();
                    mainActivity.showList(championList);
                }else{
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestChampionResponse> call, Throwable t) {

            }
        });
    }
}

/*public class MainController {



    private MainActivity view;



    private PokemonRestApi pokemonRestApi;



    private SharedPreferences sharedPreferences;



    public MainController(MainActivity view, PokemonRestApi pokemonRestApi, SharedPreferences sharedPreferences) {

        this.view = view;

        this.pokemonRestApi = pokemonRestApi;

        this.sharedPreferences = sharedPreferences;

    }



    public void start() {

        Call<RestPokemonResponse> call = pokemonRestApi.getPokemonList();

        call.enqueue(new Callback<RestPokemonResponse>() {

            @Override

            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {

                if(response.isSuccessful()) {

                    RestPokemonResponse restPokemonResponse = response.body();

                    List<Pokemon> pokemonList = restPokemonResponse.getResults();

                    storeData(pokemonList);

                    view.showList(pokemonList);

                } else {

                    System.out.println(response.errorBody());

                }

            }



            @Override

            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {

                Log.d("API ERROR", "onFailure");

                List<Pokemon> pokemonList = getDataFromCache();

                view.showList(pokemonList);

            }

        });

    }



    private void storeData(List<Pokemon> pokemonList) {

        Gson gson = new Gson();

        String listPokemonString = gson.toJson(pokemonList);

        sharedPreferences

                .edit()

                .putString("cle_string", listPokemonString)

                .apply();

    }



    private List<Pokemon> getDataFromCache() {

        String listPokemonString = sharedPreferences.getString("cle_string", "");

        if(listPokemonString != null && !TextUtils.isEmpty(listPokemonString)){

            Type listType = new TypeToken<List<Pokemon>>(){}.getType();

            List<Pokemon> pokemonList = new Gson().fromJson(listPokemonString, listType);

            return pokemonList;

        }

        return new ArrayList<>();

    }

}*/