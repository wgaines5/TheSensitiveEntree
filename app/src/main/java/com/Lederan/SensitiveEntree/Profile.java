package com.Lederan.SensitiveEntree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;
public class Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //Define menu Constants
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_profile);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        mAuth = FirebaseAuth.getInstance();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_about) {
                    Intent intent = new Intent(Profile.this, About.class);
                    startActivity(intent);
                } else if (id == R.id.nav_home) {
                    Intent intent = new Intent(Profile.this, MainActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_profile) {
                    Intent intent = new Intent(Profile.this, Profile.class);
                    startActivity(intent);
                } else if (id == R.id.search) {
                    Intent intent = new Intent(Profile.this, Search.class);
                    startActivity(intent);
                } else if (id == R.id.nav_ingredient_substitutions) {
                    Intent intent = new Intent(Profile.this, IngredientSubs.class);
                    startActivity(intent);
                } else if (id == R.id.nav_calorie_counter) {
                    Intent intent = new Intent(Profile.this, CalorieCounter.class);
                    startActivity(intent);
                } else if (id == R.id.nav_pantry) {
                    Intent intent = new Intent(Profile.this, RecipeListings.class);
                    startActivity(intent);
                } else if (id == R.id.nav_cooking_tips) {
                    Intent intent = new Intent(Profile.this, CookingTips.class);
                    startActivity(intent);
                } else if (id == R.id.nav_resources) {
                    Intent intent = new Intent(Profile.this, Resources.class);
                    startActivity(intent);
                } else if (id == R.id.nav_settings) {
                    return false;
                }else if (id == R.id.nav_logout) {
                    mAuth.signOut();
                    Intent intent = new Intent(Profile.this, Login.class);
                    startActivity(intent);
                }else {
                    return false;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public void onClickEdit(View view){
        Intent myIntent = new Intent(Profile.this, EditProfile.class);
        Profile.this.startActivity(myIntent);
    }

}
