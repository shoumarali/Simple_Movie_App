package com.example.simplemovieapp.model;

import com.example.simplemovieapp.service.MovieDataService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit=null;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static MovieDataService getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieDataService.class);
    }
}
