package com.Lederan.SensitiveEntree;

import android.content.Intent;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;


public class IngredientSubs extends AppCompatActivity{
    String[] subsOne = {"Substitution 1", "Substitution 2", "Substitution 3", "Substitution 4"};
    AutoCompleteTextView autocompletetextview;
    ArrayAdapter<String> subItems;
    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_subs);

    }


}
