package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
Handler logoHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoHandler = new Handler();
        logoHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("Login",MODE_PRIVATE);
               boolean val =  pref.getBoolean("flag",false);
               if(val) {
                   Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                   startActivity(intent);
               }
               else {
                   Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                   startActivity(intent);
               }
                finish();
            }
        }, 3000);
    }
}