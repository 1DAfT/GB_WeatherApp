package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private static final String LOG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();
        Log.i(LOG, "onCreate");

        getSupportActionBar().hide();//убираем экшн-бар
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//прячем пуш-панель (свайп-бар)


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
