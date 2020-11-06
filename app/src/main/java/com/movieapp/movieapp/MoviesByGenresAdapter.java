package com.movieapp.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.movieapp.movieapp.databinding.MoviesRowBinding;
import com.movieapp.movieapp.models.MoviesByGenresModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesByGenresAdapter extends RecyclerView.Adapter<MoviesByGenresAdapter.GenresMovieViewHolder> {

    private Activity context;
    private List<MoviesByGenresModel> list;
    public final static String IMAGE_URL = "https://image.tmdb.org/t/p/w500";//(​https://image.tmdb.org/t/p/​w500/
    public static final String MOVIE_NAME = "MOVIE_DETAIL";
    public static final String MOVIE_INTENT = "MOVIE_DETAIL";

    public MoviesByGenresAdapter(Activity context, List<MoviesByGenresModel> list) {
        this.context = context;
        this.list = list;
        Log.e("ssize", "" + list.size());
    }

    @NonNull
    @Override
    public GenresMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_row, parent, false);
        MoviesRowBinding binding = DataBindingUtil.inflate(context.getLayoutInflater(),
                R.layout.movies_row, parent, false);
        return new GenresMovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenresMovieViewHolder holder, int position) {
        holder.setBinding(list.get(position));
//        Log.e("image" , imageURL + list.get(position).getPosterPath());


        Uri uri = Uri.parse(IMAGE_URL + list.get(position).getPoster_path());//"https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
        holder.movieImage.setImageURI(uri);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra(MOVIE_INTENT, list.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GenresMovieViewHolder extends RecyclerView.ViewHolder {
        MoviesRowBinding binding;
        SimpleDraweeView movieImage;
//        TextView name, type, popularity, rate;

        public GenresMovieViewHolder(MoviesRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            movieImage = itemView.findViewById(R.id.raw_movies_movie);
//            rate = itemView.findViewById(R.id.raw_movies_rate);
//            name = itemView.findViewById(R.id.raw_movies_name);
//            type = itemView.findViewById(R.id.raw_movies_type);
//            popularity = itemView.findViewById(R.id.raw_movies_review);
        }

        public void setBinding(MoviesByGenresModel model){
            binding.setModel(model);
            binding.executePendingBindings();
        }
    }
}
