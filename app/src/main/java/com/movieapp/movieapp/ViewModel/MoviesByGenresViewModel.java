package com.movieapp.movieapp.ViewModel;

import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.repository.MoviesByGenresRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoviesByGenresViewModel extends ViewModel {
    private MutableLiveData<BaseData> data;

    public LiveData<BaseData> getData() {
        return data;
    }

    public void initialization(){
        if (data != null)
            return;
        data = MoviesByGenresRepository.getInstance().getMoviesByGenresRepository();
    }
}
