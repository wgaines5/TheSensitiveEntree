package com.Lederan.SensitiveEntree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
    String fistName = "";
    String lastName ="";
    String emailAddress="";
    String password="";
    public void onClickRegister(View view){
        EditText f = findViewById(R.id.getFirstName);
        EditText l = findViewById(R.id.getLastName);
        EditText e = findViewById(R.id.getEmail);
        EditText p = findViewById(R.id.getPassword);
        EditText c = findViewById(R.id.getConfirmPassword);
        ImageView x = findViewById(R.id.errorX);

        if(p != c){
            x.setVisibility(View.VISIBLE);
        }
    }
}