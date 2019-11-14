package com.example.weatherapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private static final String LOG = "MainActivity";
    TextView setting1, setting2, setting3;
    private static final int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onCreate");

        getSupportActionBar().hide();//убираем экшн-бар
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//прячем пуш-панель (свайп-бар)

        findViewById(R.id.main_menuButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//кнопка перехода в настройки
                CitySettings();
            }
        });

        setting1 = findViewById(R.id.main_setting1);
        setting2 = findViewById(R.id.main_setting2);
        setting3 = findViewById(R.id.main_setting3);
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



    //Переход в активити с обратной передачей данных
    public void CitySettings(){
        Intent intent = new Intent(MainActivity.this, CitySettings.class);
        resetWeatherSettingSet();
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode != REQUEST_CODE || resultCode != RESULT_OK)return;
        weatherSettingSet(data.getExtras().getBoolean("humidity"), data.getExtras().getBoolean("pressure"), data.getExtras().getBoolean("wind"));
        ((TextView)findViewById(R.id.main_city)).setText(data.getStringExtra("cityName"));
    }



    //логгирование
    public void logs(String s){
        Toast.makeText(getApplicationContext(), ".Main " + s, Toast.LENGTH_SHORT).show();
        Log.i(LOG, s);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logs("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logs("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logs("onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logs("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logs("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logs("onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logs("onBackPressed");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logs("onSaveInstanceState");
    }
}
