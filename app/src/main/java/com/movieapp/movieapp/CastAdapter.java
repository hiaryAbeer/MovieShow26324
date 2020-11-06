package com.movieapp.movieapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.movieapp.movieapp.models.CastModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.movieapp.movieapp.MoviesByGenresAdapter.IMAGE_URL;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {
    private Context context;
    private List<CastModel> list;

    public CastAdapter(Context context, List<CastModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_cast, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {

        if (list.get(position).getProfile_path() != null) {
            Uri uri = Uri.parse(IMAGE_URL + list.get(position).getProfile_path());//"https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
            holder.draweeView.setImageURI(uri);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CastViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView draweeView;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            draweeView = itemView.findViewById(R.id.raw_cast_image);
        }
    }
}
