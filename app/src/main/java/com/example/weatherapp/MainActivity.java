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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onCreate");

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViewById(R.id.main_menuButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CitySettings();
            }
        });

        ((TextView)findViewById(R.id.main_city)).setText(CitySettingModel.getInstance().getCityName());

    }
    public void CitySettings(){
        startActivity(new Intent(this,CitySettings.class));
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),".Main onStart()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onStar");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),".Main onStop()", Toast.LENGTH_LONG).show();
        Log.i(LOG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),".Main onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),".Main onPause()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),".Main onResume()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),".Main onRestart()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(),".Main onBackPressed()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onBackPressed");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(),".Main onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onSaveInstanceState");
    }
}
