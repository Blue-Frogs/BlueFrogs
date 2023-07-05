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
    Integer[] allHot = {
            R.drawable.red_hot,
            R.drawable.blue_hot,
            R.drawable.yellow_hot

    };

    Integer[] allAvg = {
            R.drawable.red_average,
            R.drawable.blue_average,
            R.drawable.yellow_average

    };

    Integer[] allCold = {
            R.drawable.red_cold,
            R.drawable.blue_cold,
            R.drawable.yellow_cold

    };

    Integer[] redHot = {
            R.drawable.red_hot
    };
    Integer[] blueHot = {
            R.drawable.blue_hot
    };
    Integer[] yellowHot = {
            R.drawable.yellow_hot
    };


    Integer[] redAvg = {
            R.drawable.red_average
    };
    Integer[] blueAvg = {
            R.drawable.blue_average
    };
    Integer[] yellowAvg = {
            R.drawable.yellow_average
    };


    Integer[] redCold = {
            R.drawable.red_cold
    };
    Integer[] blueCold = {
            R.drawable.blue_cold
    };
    Integer[] yellowCold = {
            R.drawable.yellow_cold
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
            imageView.setImageResource(allHot[r.nextInt(allHot.length)]);
        }
        else if(temperature >=60)

        {
            //warm
            imageView.setImageResource(allAvg[r.nextInt(allAvg.length)]);
        }
        else

        {
            //cold
            imageView.setImageResource(allCold[r.nextInt(allCold.length)]);
        }

        // The purpose of this is simply to enable the generate new outfit button to work, code repeat is intentional
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temperature >=100)

                {
                    //hot
                    imageView.setImageResource(allHot[r.nextInt(allHot.length)]);

                }
                else if(temperature >=60)

                {
                    //warm
                    imageView.setImageResource(allAvg[r.nextInt(allAvg.length)]);
                }
                else

                {
                    //cold
                    imageView.setImageResource(allCold[r.nextInt(allCold.length)]);
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
