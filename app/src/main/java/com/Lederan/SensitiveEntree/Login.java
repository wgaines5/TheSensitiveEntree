package com.Lederan.SensitiveEntree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;


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
    public void onCreateAccountClick(View view){
        Intent myIntent = new Intent(Login.this, Registration.class);
        Login.this.startActivity(myIntent);
    }

}