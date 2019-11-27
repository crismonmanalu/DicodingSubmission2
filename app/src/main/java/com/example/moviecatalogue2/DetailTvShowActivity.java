package com.example.moviecatalogue2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailTvShowActivity extends AppCompatActivity {
    public static String EXTRA_TVSHOW= "extra_movie";
    private Model tvShowModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        tvShowModel = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        if (tvShowModel == null) return;

        ImageView poster = findViewById(R.id.img_photo_tvshow);
        TextView judul = findViewById(R.id.judul_tvshow);
        TextView genre = findViewById(R.id.genre_tvshow);
        TextView detail = findViewById(R.id.deskripsi_tvshow);

        poster.setImageResource(tvShowModel.getPhoto());
        judul.setText(tvShowModel.getName());
        genre.setText(tvShowModel.getGenre());
        detail.setText(tvShowModel.getDetail());
    }
}
