package com.example.simplemovieapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplemovieapp.R;
import com.example.simplemovieapp.databinding.MovieListItemBinding;
import com.example.simplemovieapp.model.Movies;
import com.example.simplemovieapp.view.MovieActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movies> moviesArrayList;

    public MovieAdapter(Context context, ArrayList<Movies> moviesArrayList){
        this.context = context;
        this.moviesArrayList = moviesArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item,
                parent,
                false
        );
        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movies movies = moviesArrayList.get(position);
        holder.movieListItemBinding.setMovie(movies);
    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        MovieListItemBinding movieListItemBinding;
        public MovieViewHolder(@NonNull MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener((view) -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    Movies selectedMovie = moviesArrayList.get(position);
                    Intent i = new Intent(context, MovieActivity.class);
                    i.putExtra("movie",selectedMovie);
                    context.startActivity(i);
                }
            });
        }
    }

}
