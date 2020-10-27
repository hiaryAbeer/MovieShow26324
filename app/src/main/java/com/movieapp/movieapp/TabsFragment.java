package com.movieapp.movieapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movieapp.movieapp.ViewModel.MoviesByGenresViewModel;
import com.movieapp.movieapp.databinding.FragmentTabsBinding;
import com.movieapp.movieapp.models.MovieGeners;
import com.movieapp.movieapp.models.MoviesByGenresModel;

import java.util.ArrayList;
import java.util.List;

public class TabsFragment extends Fragment {

    private static final String SECTION_NAME = "section_name";
    private static final String SECTION_ID = "section_id";
    private MovieGeners movieGenersModel = new MovieGeners();
    private FragmentTabsBinding binding;
    private RecyclerView recyclerView;
    private MoviesByGenresViewModel moviesByGenresViewModel;
    private List<MoviesByGenresModel> byGenresModelList = new ArrayList<>();

    public TabsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @return A new instance of fragment TabsFragment.
     */
    public static TabsFragment newInstance(String name, int id) {
        TabsFragment fragment = new TabsFragment();
        Bundle args = new Bundle();
        args.putString(SECTION_NAME, name);
        args.putInt(SECTION_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);

        if (getArguments() != null) {
            movieGenersModel.setId(getArguments().getInt(SECTION_ID));
            movieGenersModel.setName(getArguments().getString(SECTION_NAME));
        }
        Log.e("getArguments", "" + movieGenersModel.getName() + movieGenersModel.getId());
//        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tabs, container, false);
//        binding = DataBindingUtil.bind(root);

//            binding.recyclerViewMoviesByGenres.setLayoutManager(new GridLayoutManager(container.getContext(), 2));

        recyclerView = root.findViewById(R.id.recyclerView_moviesByGenres);
        recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 2));
        getMoviesByTypeRequest();

        return root;
    }

    void getMoviesByTypeRequest() {

        moviesByGenresViewModel = ViewModelProviders.of(this).get(MoviesByGenresViewModel.class);
        moviesByGenresViewModel.initialization();
        moviesByGenresViewModel.getData().observe(this, response -> {

            byGenresModelList = response.getMoviesByGenresModelList();
//            int i = 0;
            boolean found;
            Log.e("thisid_type", "" + movieGenersModel.getId() + movieGenersModel.getName());
            for (int i = 0; i < byGenresModelList.size(); i++) {
                found = false;
                for (int k = 0; k < byGenresModelList.get(i).getGenre_ids().size(); k++) {
//                    Log.e("thisid", byGenresModelList.get(i).getTitle() + "  id:  " +byGenresModelList.get(i).getGenre_ids().get(k));
                    if (byGenresModelList.get(i).getGenre_ids().get(k) == movieGenersModel.getId()) {
                        Log.e("thisid", "true     " + byGenresModelList.get(i).getTitle() + "  id:  " +byGenresModelList.get(i).getGenre_ids().get(k));
                        found = true;
                        break;
                    } else {
                        Log.e("thisid", ":false     " +byGenresModelList.get(i).getTitle() + "  id:  " +byGenresModelList.get(i).getGenre_ids().get(k));
                        found = false;
                    }
                }
                if (!found) {
                    Log.e("thisid", ":remove" +byGenresModelList.get(i).getTitle());
                    byGenresModelList.remove(i);
                }
            }


            MoviesByGenresAdapter moviesAdapter = new MoviesByGenresAdapter(getContext(), byGenresModelList);
            recyclerView.setAdapter(moviesAdapter);
        });


    }
}