package com.Lederan.SensitiveEntree;
import com.Lederan.SensitiveEntree.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        } else if (id == R.id.nav_home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
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
            return false;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
