package com.movieapp.movieapp.ViewModel;

import com.movieapp.movieapp.models.MovieVideoModel;
import com.movieapp.movieapp.repository.MovieVideoRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieVideoViewModel extends ViewModel {
    private MutableLiveData<MovieVideoModel> data;

    public LiveData<MovieVideoModel> getData() {
        return data;
    }

    public void initialization(long id) {
        if (data != null)
            return;

        data = MovieVideoRepository.getInstance().playMovieRepository(id);
    }
}
