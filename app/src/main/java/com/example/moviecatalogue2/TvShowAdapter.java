package com.example.moviecatalogue2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {
    private ArrayList<Model> listTvShows;

    public TvShowAdapter(ArrayList<Model> list) {
        this.listTvShows = list;
    }
    @NonNull
    @Override
    public TvShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Model tvShows = listTvShows.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShows.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvShowTitle.setText(tvShows.getName());
        holder.tvShowGenre.setText(tvShows.getGenre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShows);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvShowTitle, tvShowGenre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvShowTitle = itemView.findViewById(R.id.movie_name);
            tvShowGenre = itemView.findViewById(R.id.movie_genre);

        }
    }
}
