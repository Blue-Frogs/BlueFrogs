package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Recommend extends AppCompatActivity {
    TextView cityNameTV, temperatureTV, windTV;
    private String cityName, temperature, wind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        cityNameTV = findViewById(R.id.idTVCityName);
        temperatureTV = findViewById(R.id.idTVTemperature);
        windTV = findViewById(R.id.idTVWind);

        Intent intent = getIntent();
        cityName = intent.getStringExtra(MainActivity.EXTRA_CITY_NAME);
        temperature = intent.getStringExtra(MainActivity.EXTRA_TEMPERATURE);
        wind = intent.getStringExtra(MainActivity.EXTRA_WIND);

        cityNameTV.setText(cityName);
        temperatureTV.setText(temperature);
        windTV.setText(wind + "mph");
    }
}