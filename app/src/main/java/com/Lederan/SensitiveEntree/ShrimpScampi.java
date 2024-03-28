package com.Lederan.SensitiveEntree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ShrimpScampi extends AppCompatActivity {

    //Widget Variables

    TextView RecipeNameDetails_textView;
    ImageView RecipeImage_imageview;
    ImageButton backRecipes_button, hamburgerIcon_imageButton;
    Button ingredSub_button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrimpScampi);

    }

    //Back button onClick
    public void onClickBack(View view){
        Intent myintent = new Intent(ShrimpScampi.this, RecipeListings.class);
        ShrimpScampi.this.startActivity(myintent);
    }

    //Ingredient substitutions button onClick
    public void onClickIngredientSubs(View view){
        Intent myintent = new Intent(ShrimpScampi.this, IngredientSubs.class);
        ShrimpScampi.this.startActivity(myintent);
    }

    //Resource button onClick
    public void onClickResource(View view){
        Intent myintent = new Intent(ShrimpScampi.this, Resources.class);
        ShrimpScampi.this.startActivity(myintent);
    }
}
