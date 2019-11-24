package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainWeekAdapter extends RecyclerView.Adapter<MainWeekAdapter.ViewHolder> {
    private String[] daysArray, temperatureArray;
    public MainWeekAdapter(String[] daysArray, String[] temperatureArray) {
        this.daysArray = daysArray;
        this.temperatureArray = temperatureArray;
    }

    @NonNull
    @Override
    public MainWeekAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.main_week_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainWeekAdapter.ViewHolder viewHolder, int i) {
        viewHolder.getDayView().setText(daysArray[i]);
        viewHolder.getTempView().setText(temperatureArray[i]);
    }

    @Override
    public int getItemCount() {
        return daysArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dayView, tempView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayView = itemView.findViewById(R.id.nextDay_name);
            tempView = itemView.findViewById(R.id.nextDay_temperature);
        }
        public TextView getDayView() {
            return dayView;
        }
        public TextView getTempView() { return tempView; }
    }
}
