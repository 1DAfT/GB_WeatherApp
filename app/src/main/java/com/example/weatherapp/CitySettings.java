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
    private static String CITY_NAME = "City", SWW = "Wind", SWP = "Pressure", SWH = "Humidity";
    private static final String LOG2 = "CityActivity";

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

        setText((TextView)findViewById(R.id.city_name1));
        setText((TextView)findViewById(R.id.city_name2));
        setText((TextView)findViewById(R.id.city_name3));
        setText((TextView)findViewById(R.id.city_name4));
        setText((TextView)findViewById(R.id.city_name5));
        setText((TextView)findViewById(R.id.city_name6));
        setText((TextView)findViewById(R.id.city_name7));
        setText((TextView)findViewById(R.id.city_name8));
        setText((TextView)findViewById(R.id.city_name9));
        setText((TextView)findViewById(R.id.city_name10));
        setText((TextView)findViewById(R.id.city_name11));

        restoreData(savedInstanceState);

        Button backButton = findViewById(R.id.city_BackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBack();
            }
        });
    }

    private void setText(final TextView text){
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText)findViewById(R.id.city_search)).setText(text.getText().toString());
            }
        });
    }

    private void restoreData(Bundle savedInstanceState) {
        if(savedInstanceState == null) return;
        Wind.setChecked(savedInstanceState.getBoolean(SWW, false));
        Humidity.setChecked(savedInstanceState.getBoolean(SWH, false));
        Pressure.setChecked(savedInstanceState.getBoolean(SWP, false));
        citySearch.setText(savedInstanceState.getString(CITY_NAME, "City"));
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

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString(city_Name, citySearch.getText().toString());
//    }
}
