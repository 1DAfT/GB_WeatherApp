package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class CitySettings extends MainActivity {
    private EditText citySearch;
    private Switch Wind, Humidity, Pressure;
    private static String city_Name = "CityName";
    private boolean WindSw = true, HumiditySw = true, PressureSw =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button backButton = findViewById(R.id.city_BackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBack();
            }
        });

        Wind = findViewById(R.id.city_windSpeedSwitch);
        Humidity = findViewById(R.id.city_humiditySwitch);
        Pressure = findViewById(R.id.city_pressureSwitch);
        restoreData(savedInstanceState);
    }

    private void restoreData(Bundle savedInstanceState) {
        if(savedInstanceState == null) return;
        Wind.setChecked(savedInstanceState.getBoolean(String.valueOf(WindSw), true));
        Humidity.setChecked(savedInstanceState.getBoolean(String.valueOf(HumiditySw), true));
        Pressure.setChecked(savedInstanceState.getBoolean(String.valueOf(PressureSw), true));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(city_Name, citySearch.getText().toString());
    }

    public void onBack(){
        finish();
    }
}
