package com.Lederan.SensitiveEntree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.primary_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
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
    }
}
