package com.movieapp.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.movieapp.movieapp.ViewModel.MovieGenericViewModel;
import com.movieapp.movieapp.databinding.ActivityMoviesBinding;
import com.movieapp.movieapp.models.MovieGeners;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private ActivityMoviesBinding binding;
    private MovieGenericViewModel genericViewModel;
    private List<MovieGeners> movieGenersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies);
        Fresco.initialize(this);

        binding.moviesTabs.setupWithViewPager(binding.moviesViewPager);
        getGenericMovies();

    }

    void getGenericMovies(){
        genericViewModel = ViewModelProviders.of(MoviesActivity.this).get(MovieGenericViewModel.class);
        genericViewModel.initialization();
        genericViewModel.getData().observe(MoviesActivity.this, response -> {
            if (response != null){
                movieGenersList = response.getMovieGeners();
                TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), movieGenersList);
                binding.moviesViewPager.setAdapter(tabAdapter);
                Log.e("size" , "" + movieGenersList.size());
            }else
                Toast.makeText(MoviesActivity.this, R.string.error_in_the_service, Toast.LENGTH_SHORT).show();

        });

    }
}