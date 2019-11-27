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


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowsFragment extends Fragment {
    RecyclerView recyclerView;
    private ArrayList<Model> tvshowlist = new ArrayList<>();


    public TVShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);

        recyclerView = view.findViewById(R.id.rv_tv_show);
        recyclerView.setHasFixedSize(true);

        tvshowlist.addAll(getData());
        showReclylerList();

        return view;
    }

    public ArrayList<Model> getData(){
        String[] dataDescription = getResources().getStringArray(R.array.detail_tvshow);
        String[] dataTitle = getResources().getStringArray(R.array.data_name_tvshow);
        String[] dataGenre = getResources().getStringArray(R.array.genre_tvshow);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.photo_tvshow);

        ArrayList<Model> listTvShow = new ArrayList<>();
        for(int i = 0; i<dataTitle.length; i++){
            Model tvshow = new Model();
            tvshow.setName(dataTitle[i]);
            tvshow.setGenre(dataGenre[i]);
            tvshow.setPhoto(dataPhoto.getResourceId(i, -1));
            tvshow.setDetail(dataDescription[i]);

            listTvShow.add(tvshow);
        }
        return listTvShow;
    }

    private void showReclylerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(tvshowlist);
        recyclerView.setAdapter(tvShowAdapter);
    }

}
