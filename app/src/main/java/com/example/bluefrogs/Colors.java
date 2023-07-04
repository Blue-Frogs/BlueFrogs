package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class Colors extends AppCompatActivity {

    Button preferenceB; //For returning to Preference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        preferenceB = findViewById(R.id.idBPreference); //For returning to Preference

        //Return to Preference page when button is clicked
        preferenceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPreference();
            }
        });
    }

    //Method to open Preference Page from Colors class
    public void openPreference(){
        Intent intent = new Intent(this, Preference.class);
        startActivity(intent);
        finish();
    }
}