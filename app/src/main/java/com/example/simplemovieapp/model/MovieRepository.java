package com.example.simplemovieapp.model;


import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.simplemovieapp.R;
import com.example.simplemovieapp.service.MovieDataService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private ArrayList<Movies> movies= new ArrayList<>();
    MutableLiveData<List<Movies>> mutableLiveData = new MutableLiveData<>();
    private Application application;


    public MovieRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Movies>> getMutableLiveData() {
        MovieDataService movieDataService = RetrofitInstance.getInstance();
        Call<Results> call = movieDataService
                .getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results result = response.body();
                if(result != null && result.getResults() != null){
                    movies = (ArrayList<Movies>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

}
