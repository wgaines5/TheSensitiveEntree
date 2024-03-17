package com.Lederan.SensitiveEntree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

public class EditProfile extends AppCompatActivity{


        DrawerLayout drawerLayout;
        NavigationView navigationView;
        Toolbar toolbar;
        //Define menu Constants
        FirebaseAuth mAuth;

        EditText editPassword;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_profile);

            editPassword = findViewById(R.id.editTextTextPasswordConfirm);

        }

        /*CLicking password to edit will bring up password confirmation edit text.
        Still working to get it smooth*/
    public void onPasswordClick(View view){
            if(editPassword.getVisibility() ==  View.INVISIBLE) {
                editPassword.setVisibility(View.VISIBLE);
            }
    }

    /*Click back button to go back to Profile page*/
    public void onClickBack(View view){
        Intent myIntent = new Intent(EditProfile.this, Profile.class);
        EditProfile.this.startActivity(myIntent);
    }

    /*Need Firebase integration. But after the firebase validation it should go back to
    * the Profile page. For now it will just go back to the Profile page.*/
    public void onClickSave(View view){
        Intent myIntent = new Intent(EditProfile.this, Profile.class);
        EditProfile.this.startActivity(myIntent);
    }
}
