package com.Lederan.SensitiveEntree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;
import android.view.View;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class About extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //Define menu Constants
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_about);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        mAuth = FirebaseAuth.getInstance();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_about) {
                    Intent intent = new Intent(About.this, About.class);
                    startActivity(intent);
                } else if (id == R.id.nav_home) {
                    Intent intent = new Intent(About.this, MainActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_profile) {
                    return false;
                } else if (id == R.id.search) {
                    return false;
                } else if (id == R.id.nav_ingredient_substitutions) {
                    return false;
                } else if (id == R.id.nav_calorie_counter) {
                    return false;
                } else if (id == R.id.nav_pantry) {
                    return false;
                } else if (id == R.id.nav_cooking_tips) {
                    return false;
                } else if (id == R.id.nav_resources) {
                    return false;
                } else if (id == R.id.nav_settings) {
                    return false;
                }else if (id == R.id.nav_logout) {
                    return false;
                }else {
                    mAuth.signOut();
                    Intent intent = new Intent(About.this, Login.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void showAssist() {
    }
}