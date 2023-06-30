package com.example.bluefrogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private TextView usernameTV;
    private TextView passwordTV;
    private Button signupB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //signupB = findViewById(R.id.idBsignup);
        //usernameTV = findViewById(R.id.idETusername);
        //passwordTV = findViewById(R.id.idETpassword);
    }
}