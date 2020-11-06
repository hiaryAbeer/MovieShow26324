package com.movieapp.movieapp;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.movieapp.movieapp.ViewModel.MovieVideoViewModel;
import com.movieapp.movieapp.databinding.ActivityPlayMovieBinding;
import com.movieapp.movieapp.models.MovieVideoModel;
import com.movieapp.movieapp.models.MoviesByGenresModel;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;
import static com.movieapp.movieapp.MovieDetails.MOVIE_ID;

public class PlayMovie extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private ActivityPlayMovieBinding binding;
    public static final String API_KEY = "AIzaSyDi2qchqCUwMjAx0OvFD_-eTWBUpHb1z6Y";
    private MovieVideoModel videoModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_movie);
        videoModel = (MovieVideoModel) getIntent().getSerializableExtra(MOVIE_ID);
        binding.youtubePlayer.initialize(API_KEY, this);// inside on click
    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.loadVideo(videoModel.getKey());
//        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
//            @Override
//            public void onLoading() {
//
//            }
//
//            @Override
//            public void onLoaded(String s) {
//
//            }
//
//            @Override
//            public void onAdStarted() {
//
//            }
//
//            @Override
//            public void onVideoStarted() {
//
//            }
//
//            @Override
//            public void onVideoEnded() {
//
//            }
//
//            @Override
//            public void onError(YouTubePlayer.ErrorReason errorReason) {
//
//            }
//        });
//        youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
//            @Override
//            public void onPlaying() {
//
//            }
//
//            @Override
//            public void onPaused() {
//
//            }
//
//            @Override
//            public void onStopped() {
//
//            }
//
//            @Override
//            public void onBuffering(boolean b) {
//
//            }
//
//            @Override
//            public void onSeekTo(int i) {
//
//            }
//        });
//        Log.e("video1", videoModel.getVideoId() );
//        if (!wasRestored) {
//            // TODO change video id
//            if (!videoModel.getVideoId().equals(null)) {
//                youTubePlayer.cueVideo(String.valueOf(videoModel.getVideoId()));
//                Log.e("video2", videoModel.getVideoId() );
//
//            }
//        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}