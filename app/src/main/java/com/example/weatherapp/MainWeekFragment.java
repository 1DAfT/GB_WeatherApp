package com.example.weatherapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainWeekFragment extends Fragment {
    private View rootView;

    public MainWeekFragment(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_week_fragment, container, false);

        String[] daysArray = resourceUtils.getLocalizedStringArray(getActivity(), getResources().getStringArray(R.array.days_array));
        String[] tempArray = resourceUtils.getLocalizedStringArray(getActivity(), getResources().getStringArray(R.array.days_temperature_array));
        initReciclerView(daysArray, tempArray);

        return rootView;
    }

    public void initReciclerView(String[] daysArray, String[] tempArray){
        RecyclerView recyclerView = rootView.findViewById(R.id.week_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new MainWeekAdapter(daysArray, tempArray));
    }
}
