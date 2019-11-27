package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CitySettings extends MainActivity {
    private EditText citySearch;
    private Switch Wind, Humidity, Pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_main);

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Wind = findViewById(R.id.city_windSpeedSwitch);
        Humidity = findViewById(R.id.city_humiditySwitch);
        Pressure = findViewById(R.id.city_pressureSwitch);
        citySearch = findViewById(R.id.city_search);

        restoreData();

        Button backButton = findViewById(R.id.city_BackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button okButton = findViewById(R.id.city_okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                onBack();
            }
        });
    }

    private void restoreData() {
        Wind.setChecked(CitySettingModel.getInstance().isWindSw());
        Humidity.setChecked(CitySettingModel.getInstance().isHumiditySw());
        Pressure.setChecked(CitySettingModel.getInstance().isPressureSw());
        citySearch.setText(CitySettingModel.getInstance().getCityName());
    }

    public void saveData(){
        CitySettingModel.getInstance().setWindSw(Wind.isChecked());
        CitySettingModel.getInstance().setPressureSw(Pressure.isChecked());
        CitySettingModel.getInstance().setHumiditySw(Humidity.isChecked());
        CitySettingModel.getInstance().setCityName(citySearch.getText().toString());
    }

    public void onBack(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("cityName", citySearch.getText().toString());
        resultIntent.putExtra("humidity", Humidity.isChecked());
        resultIntent.putExtra("wind", Wind.isChecked());
        resultIntent.putExtra("pressure", Pressure.isChecked());
        setResult(RESULT_OK, resultIntent);
        finish();
    }

}
