package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


// added to enable random image generation
import java.util.Random;

public class Recommend extends AppCompatActivity {

    ImageView imageView;

    Button button;
    TextView cityNameTV, temperatureTV, windTV, hotTempTV;
    Button weatherB;
    private String cityName, temperatureString, wind;
    private double temperature;

    Random r;

    // Generates random image from these three below
    Integer[] images = {
            R.drawable.htemp1,
            R.drawable.htemp2,
            R.drawable.htemp3
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        imageView = (ImageView) findViewById(R.id.imageView);

        button = (Button) findViewById(R.id.button);

        r = new Random();

        cityNameTV = findViewById(R.id.idTVCityName);
        temperatureTV = findViewById(R.id.idTVTemperature);
        windTV = findViewById(R.id.idTVWind);
        weatherB = findViewById(R.id.idBWeather);

        // Testing if text pops up based on temperature range
        hotTempTV = findViewById(R.id.idTVHotTemp);

        //Get current city name, temperature, and wind speed from MainActivity page
        Intent intent = getIntent();
        cityName = intent.getStringExtra(MainActivity.EXTRA_CITY_NAME);
        temperatureString = intent.getStringExtra(MainActivity.EXTRA_TEMPERATURE);
        temperature = Double.parseDouble(temperatureString);
        wind = intent.getStringExtra(MainActivity.EXTRA_WIND);

        //Set city name, temperature, and wind into Text View
        cityNameTV.setText(cityName);
        temperatureTV.setText(temperature + "°F");
        windTV.setText(wind + "mph");


        //Go back to MainActivity page
        weatherB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });



        // Snippet here enables the image to automatically load upon clicking "show outfits"
        if(temperature >=100)

        {
            //hot
            hotTempTV.setText("Cool clothing to beat the heat");
            imageView.setImageResource(images[r.nextInt(images.length)]);
        }
        else if(temperature >=60)

        {
            //warm
        }
        else

        {
            //cold
        }

        // The purpose of this is simply to enable the generate new outfit button to work, code repeat is intentional
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temperature >=100)

                {
                    //hot
                    imageView.setImageResource(images[r.nextInt(images.length)]);
                }
                else if(temperature >=60)

                {
                    //warm
                }
                else

                {
                    //cold
                }
            }

        });

    }


    public void openMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
