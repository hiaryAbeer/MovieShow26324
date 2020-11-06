package com.movieapp.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.movieapp.movieapp.ViewModel.CastViewModel;
import com.movieapp.movieapp.ViewModel.MovieVideoViewModel;
import com.movieapp.movieapp.databinding.ActivityMovieDetailsBinding;
import com.movieapp.movieapp.models.CastModel;
import com.movieapp.movieapp.models.MovieVideoModel;
import com.movieapp.movieapp.models.MoviesByGenresModel;

import java.util.ArrayList;
import java.util.List;

import static com.movieapp.movieapp.MoviesByGenresAdapter.IMAGE_URL;
import static com.movieapp.movieapp.MoviesByGenresAdapter.MOVIE_INTENT;

public class MovieDetails extends AppCompatActivity {

    private ActivityMovieDetailsBinding binding;
    private MoviesByGenresModel model;
    private SimpleDraweeView view;
    private CastAdapter castAdapter;
    private List<CastModel> modelList = new ArrayList<>();
    private CastViewModel castViewModel;
    private OnClickHandler handler;
    public static final String MOVIE_ID = "10";
    private MovieVideoViewModel videoViewModel;
    private long videoId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);

        model = (MoviesByGenresModel) getIntent().getSerializableExtra(MOVIE_INTENT);
        binding.setDetailsModel(model);

        handler = new OnClickHandler();
        binding.setHandler(handler);

        view = findViewById(R.id.details_simpleDraweeView);
        Uri uri = Uri.parse(IMAGE_URL + model.getPoster_path());
        view.setImageURI(uri);

        getMovieCast(model.getId());

    }

    private void getMovieCast(long id) {
        castViewModel = ViewModelProviders.of(this).get(CastViewModel.class);
        castViewModel.initialization(id);
        castViewModel.getData().observe(this, response -> {
            modelList = response.getMovieCast();

            binding.recyclerViewCast.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));
            castAdapter = new CastAdapter(this, modelList);
            binding.recyclerViewCast.setAdapter(castAdapter);
        });

    }

    public class OnClickHandler {
        public void onBackClick(View view) {
            Intent intent = new Intent(MovieDetails.this, MoviesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }

        public void onLikeClick(View view) {

        }

        public void onStartClick(View view) {
            getVideo();

        }
    }

    void getVideo() {
        videoViewModel = ViewModelProviders.of(this).get(MovieVideoViewModel.class);
        videoViewModel.initialization(model.getId());
        videoViewModel.getData().observe(this, response -> {
            List<MovieVideoModel> videoModel = response.getVideoModels();
            if (videoModel != null) {
                Intent intent = new Intent(MovieDetails.this, PlayMovie.class);
                intent.putExtra(MOVIE_ID, videoModel.get(0));
                startActivity(intent);
            }
        });

    }

}