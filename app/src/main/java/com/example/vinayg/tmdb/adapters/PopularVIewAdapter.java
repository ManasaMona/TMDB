package com.example.vinayg.tmdb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vinayg.tmdb.R;
import com.example.vinayg.tmdb.models.Movie;

import java.util.ArrayList;


/**
 * Created by vinay.g.
 */

public class PopularVIewAdapter extends RecyclerView.Adapter<PopularVIewAdapter.ViewHolder>{
    public static Context context;
    private int layoutResourceId;
    private ArrayList<Movie> data;

    public PopularVIewAdapter(Context context, int layoutResourceId, ArrayList<Movie> data) {
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.movie_card_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageView image = holder.image;
        TextView imageTitle = holder.imageTitle;
        TextView release_date = holder.release_date;
        Movie movie = data.get(position);
        Glide
                .with(context)
                .load(movie.getImageUrl())
                .crossFade()
                .fitCenter()
                .into(image);
        imageTitle.setText(movie.getTitle());
        release_date.setText(movie.getRelease_date());
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public final TextView imageTitle;
        public final ImageView image;
        public final TextView release_date;

        public ViewHolder(View itemView) {
            super(itemView);
            imageTitle = (TextView) itemView.findViewById(R.id.tvMovieTitle);
            image = (ImageView) itemView.findViewById(R.id.imgBanner);
            release_date = (TextView) itemView.findViewById(R.id.tvMovieReleaseDate);
        }
    }
}

