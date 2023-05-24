package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.Models.MausamData;
import com.example.weather.Models.hari;
import com.example.weather.Models.main;
import com.example.weather.Models.sys;
import com.example.weather.Models.weather;
import com.example.weather.Models.wind;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
ImageView LongOut,Find;
EditText Search_city_name;
TextView City_name,temperature,description,sunriseTime,windSpeed,sunsetTime,humidity_in_percentage
        ,pressure_in_pascal;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LongOut = findViewById(R.id.Longout);
        Search_city_name = findViewById(R.id.Search_city_name);
        Find = findViewById(R.id.find);
        temperature = findViewById(R.id.temperature);
        sunriseTime = findViewById(R.id.sunriseTime);
        sunsetTime = findViewById(R.id.sunsetTime);
        windSpeed = findViewById(R.id.windSpeed);
        humidity_in_percentage = findViewById(R.id.humidity_in_percentage);
        pressure_in_pascal = findViewById(R.id.pressure_in_pascal);
        City_name = findViewById(R.id.City_name);
        description = findViewById(R.id.description);
        fetchWeather("Muzaffarpur");
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        String currentDate = format.format(new Date());
         LongOut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 SharedPreferences pref = getSharedPreferences("Login",MODE_PRIVATE);
                 SharedPreferences.Editor editor = pref.edit();
                 editor.putBoolean("flag",false);
                 editor.apply();
                 Intent nextIn = new Intent(HomeActivity.this,LoginActivity.class);
                 startActivity(nextIn);
                 finishAffinity();
             }
         });
         Find.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String searchCityName = Search_city_name.getText().toString();
                 if(searchCityName.isEmpty()){
                     Toast.makeText(HomeActivity.this,"please enter city name",Toast.LENGTH_SHORT).show();
                     return;
                 }
                     fetchWeather(searchCityName);
             }
         });
    }

    private void fetchWeather(String searchCityName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherInterface WeatherInterface = retrofit.create(weatherInterface.class);
        Call<MausamData> call = WeatherInterface.getData(searchCityName,"8967795249f9ac5fdc3c8e887cc08b90"
        ,"metric");

        call.enqueue(new Callback<MausamData>() {
            @Override
            public void onResponse(@NonNull Call<MausamData> call, @NonNull Response<MausamData> response) {
                if(response.isSuccessful()){
                    MausamData mausamData = response.body();
                    assert mausamData != null;
                    main to = mausamData.getMain();
                    temperature.setText(String.valueOf(to.getTemp()));
                    humidity_in_percentage.setText((String.valueOf(to.getHumidity())));
                    pressure_in_pascal.setText((String.valueOf(to.getPressure())));
                    City_name.setText(mausamData.getName());
                    List<weather> weathers = mausamData.getWeather();

                    for (weather data:weathers)
                    {
                        description.setText(data.getDescription());
                    }
                    sys s = mausamData.getSys();

                    long sunrise = s.getSunrise();
                    long sunset = s.getSunset();
                    hari H = new hari();
                    String SunriseTime = H.getSunriseTimestamp(sunrise);
                    sunriseTime.setText(SunriseTime);
                    String  SunsetTime = H.getSunsetTimestamp(sunset);
                    sunsetTime.setText(SunsetTime);
                    wind W = mausamData.getWind();
                    windSpeed.setText(String.valueOf(W.getSpeed()));
                }

            }

            @Override
            public void onFailure(@NonNull Call<MausamData> call, @NonNull Throwable t) {

            }
        });
    }
}