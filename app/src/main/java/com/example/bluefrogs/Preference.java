package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Preference extends AppCompatActivity {
    Button weatherB; //For returning to MainActivity
    private Button colorsB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        weatherB = findViewById(R.id.idBWeather); //For returning to MainActivity
        //---------colorsB = findViewById(R.id.idBColors); //For Colors page

        //Return to MainActivity page when button is clicked
        weatherB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }

            private void openMain() {
                Intent intent = new Intent(Preference.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    /*-------------------------------
        //To go to Colors Preference page
        colorsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Preference.this, Colors.class);
                startActivity(intent2);
            }
        });

     */
    }

}
