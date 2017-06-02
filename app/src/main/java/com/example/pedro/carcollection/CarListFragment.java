package com.example.pedro.carcollection;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedro.carcollection.adapters.CarsAdapter;
import com.example.pedro.carcollection.models.Car;

/**
 * A placeholder fragment containing a simple view.
 */
public class CarListFragment extends Fragment {

    private CarsAdapter adapter;

    public CarListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carslist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

         adapter = new CarsAdapter();

        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.update();
    }
}
