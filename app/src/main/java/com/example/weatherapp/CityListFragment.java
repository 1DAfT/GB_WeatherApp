package com.example.weatherapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class CityListFragment extends Fragment {
    private View rootView;
    public CityListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.city_list_fragment, container, false);

        String[] cityList = resourceUtils.getLocalizedStringArray( getActivity(),getResources().getStringArray(R.array.city_list_array));
        initRecyclerView(cityList);

        return rootView;
    }

    private void initRecyclerView(String[] cityList){
        RecyclerView recyclerView = rootView.findViewById(R.id.city_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getActivity().getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setAdapter(new CityListAdapter(cityList, new CityListClickListner() {
            @Override
            public void onClick(String data) {
                ((EditText)getActivity().findViewById(R.id.city_search)).setText(data);
            }
        }));
    }

}
