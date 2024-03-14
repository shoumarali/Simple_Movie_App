package com.example.simplemovieapp.service;

import com.example.simplemovieapp.model.Results;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService{
    @GET("movie/popular")
    Call<Results> getPopularMovies(@Query("api_key") String apiKey);
}
