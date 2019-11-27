package com.example.moviecatalogue2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<Model> movielist = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        recyclerView = view.findViewById(R.id.rv_movies);
        recyclerView.setHasFixedSize(true);

        movielist.addAll(getData());
        showRecyclerList();

        return view;
    }
    public ArrayList<Model> getData (){
        String[] dataDescription = getResources().getStringArray(R.array.detail_movie);
        String[] dataTitle = getResources().getStringArray(R.array.data_name_movie);
        String[] dataGenre = getResources().getStringArray(R.array.genre_movie);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.photo_movie);

        ArrayList<Model> listMovie = new ArrayList<>();
        for (int i = 0; i< dataTitle.length; i++){
            Model movie = new Model();
            movie.setName(dataTitle[i]);
            movie.setGenre(dataGenre[i]);
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setDetail(dataDescription[i]);

            listMovie.add(movie);
        }
        return  listMovie;
    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(movielist);
        recyclerView.setAdapter(movieAdapter);

    }

}
