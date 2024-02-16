package com.Lederan.SensitiveEntree;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    String email = "";
    String password ="";

    public void onLoginClick(View view) {
        EditText e = findViewById(R.id.enterEmailAddress);
        email = e.getText().toString();
        EditText p= findViewById(R.id.enterPassword);
        password = p.getText().toString();
    }

}