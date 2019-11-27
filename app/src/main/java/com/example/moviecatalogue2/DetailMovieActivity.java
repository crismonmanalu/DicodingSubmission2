package com.example.moviecatalogue2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    public static String EXTRA_MOVIE = "extra_movie";
    private Model movieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        movieModel = getIntent().getParcelableExtra(EXTRA_MOVIE);


        if (movieModel == null) return;

        ImageView poster = findViewById(R.id.img_photo);
        TextView judul = findViewById(R.id.judul);
        TextView genre = findViewById(R.id.genre);
        TextView detail = findViewById(R.id.deskripsi);

        poster.setImageResource(movieModel.getPhoto());
        judul.setText(movieModel.getName());
        genre.setText(movieModel.getGenre());
        detail.setText(movieModel.getDetail());
    }
}
