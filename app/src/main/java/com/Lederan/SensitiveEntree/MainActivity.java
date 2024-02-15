package com.Lederan.SensitiveEntree;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.primary_menu,menu);
        return true;
    }
    /*public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_home:
                return true;
            case R.id.menu_profile:
                return true;
            case R.id.menu_cooking_tips:
                return true;
            case R.id.menu_about:
                return true;
            case R.id.search:
                return true;
            case R.id.menu_resources:
                return true;
            case R.id.menu_ingredient_substitutions:
                return true;
            case R.id.menu_pantry:
                return true;
            case R.id.menu_settings:
                return true;
            case R.id.menu_calorie_counter:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }*/
}
