package com.Lederan.SensitiveEntree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CauliflowerSoup extends AppCompatActivity {

    //Widget Variables

    TextView RecipeNameDetails_textView;
    ImageView RecipeImage_imageview;
    ImageButton backRecipes_button, hamburgerIcon_imageButton;
    Button ingredSub_button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauliflowerSoup);

    }

    //Back button onClick
    public void onClickBack(View view){
        Intent myintent = new Intent(CauliflowerSoup.this, RecipeListings.class);
        CauliflowerSoup.this.startActivity(myintent);
    }

    //Ingredient substitutions button onClick
    public void onClickIngredientSubs(View view){
        Intent myintent = new Intent(CauliflowerSoup.this, IngredientSubs.class);
        CauliflowerSoup.this.startActivity(myintent);
    }

    //Resource button onClick
    public void onClickResource(View view){
        Intent myintent = new Intent(CauliflowerSoup.this, Resources.class);
        CauliflowerSoup.this.startActivity(myintent);
    }
}
