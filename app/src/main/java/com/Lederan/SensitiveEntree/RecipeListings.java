package com.Lederan.SensitiveEntree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.Lederan.SensitiveEntree.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

public class RecipeListings extends AppCompatActivity{

    //Widget  Variables
    TextView RecipeName_TextView, RecipeAllergenListings_textView, RecipeNameListings_textView;
    ImageButton recipeImage1_imageButton, recipeImage2_imageButton, recipeImage3_imageButton, recipeImage4_imageButton, recipeImage5_imageButton, recipeImage6_imageButton, recipeImage7_imageButton, recipeImage8_imageButton, recipeImage9_imageButton;
    Button RecipeListingsBack_button, recipeFilter_button, addRecipe_button;
    ScrollView RecipeListings_scrollView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //Define menu Constants
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_recipelistings);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.recipeListingToolbar);

        mAuth = FirebaseAuth.getInstance();
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navMenu();

    }


    public void onMenuClick(View view)
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    public void navMenu(){


    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_about) {
                    Intent intent = new Intent(RecipeListings.this, About.class);
                    startActivity(intent);
                } else if (id == R.id.nav_home) {
                    Intent intent = new Intent(RecipeListings.this, MainActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_profile) {
                    Intent intent = new Intent(RecipeListings.this, Profile.class);
                    startActivity(intent);
                } else if (id == R.id.search) {
                    Intent intent = new Intent(RecipeListings.this, Search.class);
                    startActivity(intent);
                } else if (id == R.id.nav_ingredient_substitutions) {
                    Intent intent = new Intent(RecipeListings.this, IngredientSubs.class);
                    startActivity(intent);
                } else if (id == R.id.nav_calorie_counter) {
                    Intent intent = new Intent(RecipeListings.this, CalorieCounter.class);
                    startActivity(intent);
                } else if (id == R.id.nav_pantry) {
                    Intent intent = new Intent(RecipeListings.this, RecipeListings.class);
                    startActivity(intent);
                } else if (id == R.id.nav_cooking_tips) {
                    Intent intent = new Intent(RecipeListings.this, CookingTips.class);
                    startActivity(intent);
                } else if (id == R.id.nav_resources) {
                    Intent intent = new Intent(RecipeListings.this, Resources.class);
                    startActivity(intent);
                } else if (id == R.id.nav_settings) {
                    return false;
                }else if (id == R.id.nav_logout) {
                    mAuth.signOut();
                    Intent intent = new Intent(RecipeListings.this, Login.class);
                    startActivity(intent);
                }else {
                    return false;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
    public void onClickAddRecipe(View view){
        Intent myintent = new Intent(RecipeListings.this, AddRecipe.class);
        RecipeListings.this.startActivity(myintent);
    }

}
