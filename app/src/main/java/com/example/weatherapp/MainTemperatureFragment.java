package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainTemperatureFragment extends Fragment {
    public MainTemperatureFragment() {
        // Required empty public constructor
    }
    TextView setting1, setting2, setting3;
    private static final int REQUEST_CODE = 99;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_temperature_fragment, container, false);

        rootView.findViewById(R.id.main_menuButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CitySettings();
            }
        });
        setting1 = rootView.findViewById(R.id.main_setting1);
        setting2 = rootView.findViewById(R.id.main_setting2);
        setting3 = rootView.findViewById(R.id.main_setting3);

        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    //Настройка дополнительных показателей погоды и сброс
    public void weatherSettingSet(boolean swH, boolean swP, boolean swW){
        boolean[] setFlag = {swH, swP, swW};
        String[] setData = {getString(R.string.humidity), getString(R.string.pressure), getString(R.string.windSpeed)};
        int counter = 0;
        for (boolean b: setFlag) {
            if (b) counter += 1;
        }
        if(counter == 1){
            setting3.setVisibility(View.VISIBLE);
            for (int i = 0; i < setFlag.length; i++){
                if(setFlag[i]) setting3.setText(setData[i]);
            }
        }
        else if(counter == 2){
            setting1.setVisibility(View.VISIBLE);
            setting2.setVisibility(View.VISIBLE);
            for (int i = 0; i < setFlag.length; i++){
                if(setFlag[i]){
                    setting1.setText(setData[i]);
                    if(setFlag[i+1])setting2.setText(setData[i+1]);
                    else setting2.setText(setData[i+2]);
                    break;
                }
            }
        }
        else if(counter == 3){
            setting1.setVisibility(View.VISIBLE);
            setting2.setVisibility(View.VISIBLE);
            setting3.setVisibility(View.VISIBLE);
        }

    }
    public void resetWeatherSettingSet(){
        setting1.setVisibility(View.GONE);
        setting2.setVisibility(View.GONE);
        setting3.setVisibility(View.GONE);
    }

    public void CitySettings(){
        Intent intent = new Intent(getActivity(), CitySettings.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onStop() {
        resetWeatherSettingSet();
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode != REQUEST_CODE || resultCode != MainActivity.RESULT_OK)return;
        weatherSettingSet(data.getExtras().getBoolean("humidity"), data.getExtras().getBoolean("pressure"), data.getExtras().getBoolean("wind"));
        ((TextView)getView().findViewById(R.id.main_city)).setText(data.getStringExtra("cityName"));
    }


}
