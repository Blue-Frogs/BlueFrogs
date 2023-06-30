package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Recommend extends AppCompatActivity {
    TextView cityNameTV, temperatureTV;
    private String cityName, temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        cityNameTV = findViewById(R.id.idTVCityName);
        temperatureTV = findViewById(R.id.idTVTemperature);

        Intent intent = getIntent();
        cityName = intent.getStringExtra(MainActivity.EXTRA_CITY_NAME);
        temperature = intent.getStringExtra(MainActivity.EXTRA_TEMPERATURE);

        cityNameTV.setText(cityName);
        temperatureTV.setText(temperature);
    }
}