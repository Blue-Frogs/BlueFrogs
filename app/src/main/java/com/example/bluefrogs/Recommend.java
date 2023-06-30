package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Recommend extends AppCompatActivity {
    TextView cityNameTV, temperatureTV, windTV;
    Button weatherB;
    private String cityName, temperature, wind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        cityNameTV = findViewById(R.id.idTVCityName);
        temperatureTV = findViewById(R.id.idTVTemperature);
        windTV = findViewById(R.id.idTVWind);
        weatherB = findViewById(R.id.idBWeather);

        //Get current city name, temperature, and wind speed from MainActivity page
        Intent intent = getIntent();
        cityName = intent.getStringExtra(MainActivity.EXTRA_CITY_NAME);
        temperature = intent.getStringExtra(MainActivity.EXTRA_TEMPERATURE);
        wind = intent.getStringExtra(MainActivity.EXTRA_WIND);

        //Set city name, temperature, and wind
        cityNameTV.setText(cityName);
        temperatureTV.setText(temperature);
        windTV.setText(wind + "mph");

        //Go back to MainActivity page
        weatherB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
    }

    public void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}