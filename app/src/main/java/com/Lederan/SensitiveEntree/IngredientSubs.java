package com.Lederan.SensitiveEntree;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

public class IngredientSubs extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //Define menu Constants
    FirebaseAuth mAuth;
    Spinner sub1_spinner, sub2_spinner, sub3_spinner, sub4_spinner, sub5_spinner, sub6_spinner, sub7_spinner, sub8_spinner, sub9_spinner;
    Button hamIngred_button;
    String[] subsOne = {"Substitution 1", "Substitution 2", "Substitution 3", "Substitution 4"};
    AutoCompleteTextView autocompletetextview;
    ArrayAdapter<String> subItems;
    private static final String[] subs1 = {"See Substitutions","Almond Milk", "Oat Milk", "Soy Milk", "Cashew Milk"};
    private static final String[] subs2 = {"See ","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs3 = {"See All","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs4 = {"See All","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs5 = {"See All","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs6 = {"See All","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs7 = {"See All","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs8 = {"See All","Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs9 = {"See All","Sub 1", "Sub 2", "Sub 3"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_ingredientsubs); // The menu drawer overlay of the page original layout

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        mAuth = FirebaseAuth.getInstance();

// NavigationView controls the menu drawer to access each page selected
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_about) {
                    Intent intent = new Intent(IngredientSubs.this, About.class);
                    startActivity(intent);
                } else if (id == R.id.nav_home) {
                    Intent intent = new Intent(IngredientSubs.this, MainActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_profile) {
                    Intent intent = new Intent(IngredientSubs.this, Profile.class);
                    startActivity(intent);
                } else if (id == R.id.search) {
                    Intent intent = new Intent(IngredientSubs.this, Search.class);
                    startActivity(intent);
                } else if (id == R.id.nav_ingredient_substitutions) {
                    Intent intent = new Intent(IngredientSubs.this, IngredientSubs.class);
                    startActivity(intent);
                } else if (id == R.id.nav_calorie_counter) {
                    Intent intent = new Intent(IngredientSubs.this, CalorieCounter.class);
                    startActivity(intent);
                } else if (id == R.id.nav_pantry) {
                    Intent intent = new Intent(IngredientSubs.this, RecipeListings.class);
                    startActivity(intent);
                } else if (id == R.id.nav_cooking_tips) {
                    Intent intent = new Intent(IngredientSubs.this, CookingTips.class);
                    startActivity(intent);
                } else if (id == R.id.nav_resources) {
                    Intent intent = new Intent(IngredientSubs.this, Resources.class);
                    startActivity(intent);
                } else if (id == R.id.nav_settings) {
                    return false;
                }else if (id == R.id.nav_logout) {
                    mAuth.signOut();
                    Intent intent = new Intent(IngredientSubs.this, Login.class);
                    startActivity(intent);
                }else {
                    return false;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Ingredient Subs Dropdown #1
        sub1_spinner = (Spinner)findViewById(R.id.sub1_spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs1);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub1_spinner.setAdapter(adapter);
        sub1_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #2
        sub2_spinner = (Spinner)findViewById(R.id.sub2_spinner);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs2);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub2_spinner.setAdapter(adapter);
        sub2_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #3
        sub3_spinner = (Spinner)findViewById(R.id.sub3_spinner);
        ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs3);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub3_spinner.setAdapter(adapter);
        sub3_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #4
        sub4_spinner = (Spinner)findViewById(R.id.sub4_spinner);
        ArrayAdapter<String>adapter4 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs4);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub4_spinner.setAdapter(adapter);
        sub4_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #5
        sub5_spinner = (Spinner)findViewById(R.id.sub5_spinner);
        ArrayAdapter<String>adapter5 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs5);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub5_spinner.setAdapter(adapter);
        sub5_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #6
        sub6_spinner = (Spinner)findViewById(R.id.sub6_spinner);
        ArrayAdapter<String>adapter6 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs6);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub6_spinner.setAdapter(adapter);
        sub6_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #7
        sub7_spinner = (Spinner)findViewById(R.id.sub7_spinner);
        ArrayAdapter<String>adapter7 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs7);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub7_spinner.setAdapter(adapter);
        sub7_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #8
        sub8_spinner = (Spinner)findViewById(R.id.sub8_spinner);
        ArrayAdapter<String>adapter8 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs8);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub8_spinner.setAdapter(adapter);
        sub8_spinner.setOnItemSelectedListener(this);

        // Ingredient Subs Dropdown #9
        sub9_spinner = (Spinner)findViewById(R.id.sub9_spinner);
        ArrayAdapter<String>adapter9 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                R.layout.spinner_layout,subs9);

        adapter.setDropDownViewResource(R.layout.spinner_layout);
        sub9_spinner.setAdapter(adapter);
        sub9_spinner.setOnItemSelectedListener(this);

    }

    // Back button function
    public void onClickBack(View view){
        Intent myintent = new Intent(com.Lederan.SensitiveEntree.IngredientSubs.this, RecipeDetails.class);
        com.Lederan.SensitiveEntree.IngredientSubs.this.startActivity(myintent);
    }


    //These have to be here for the spinners even with nothing in them.
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
