package com.Lederan.SensitiveEntree;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeListings extends AppCompatActivity {

    //Widget  Variables
    TextView RecipeName_TextView, RecipeAllergenListings_textView, RecipeNameListings_textView;
    ImageButton RecipeImage_imageButton;
    Button RecipeListingsBack_button, RecipeFilter_button, AddRecipe_button;
    ScrollView RecipeListings_scrollView;

    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_listings);

    }
}
