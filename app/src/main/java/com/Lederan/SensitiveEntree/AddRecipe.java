package com.Lederan.SensitiveEntree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

    }
    public void onClickBack(View view){
        Intent myintent = new Intent(com.Lederan.SensitiveEntree.AddRecipe.this, RecipeListings.class);
        com.Lederan.SensitiveEntree.AddRecipe.this.startActivity(myintent);
    }
}
