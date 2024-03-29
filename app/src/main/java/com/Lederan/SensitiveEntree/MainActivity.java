package com.Lederan.SensitiveEntree;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.Lederan.SensitiveEntree.databinding.ActivityMainBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    ImageView PBJ;
    ActivityMainBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;

    // Validates the user
    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //Check is now added if the user is null or not.
        if(currentUser != null)
        {
            currentUser.getIdToken(true).addOnCompleteListener(task ->
            {
                if (!task.isSuccessful()) {
                    mAuth.signOut();
                    Intent myIntent = new Intent(MainActivity.this, Login.class);
                    MainActivity.this.startActivity(myIntent);
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);
        // Variables
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        PBJ = findViewById(R.id.PBJ);
        // Get a reference to the Firebase Storage location
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference().child("Food").child("1200px-Peanut-Butter-Jelly-Sandwich.jpg");

        //==================================================================================
        // For hamburger control
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        sidbarNav();
        //=================================================================================


        //=================================================================================
        //Attached an image to the id PBJ and links the image to the recipe page.
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into ImageView using Glide
                Glide.with(MainActivity.this)
                        .load(uri)
                        .apply(RequestOptions.circleCropTransform()) // Apply transformations if needed
                        .into(PBJ);
            }
        });

        ImageView imageView = findViewById(R.id.PBJ);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                startActivity(intent);
            }
        });
    } //=================================================================================
    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    public void sidbarNav()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                    Intent intent = new Intent(MainActivity.this, Profile.class);
                    startActivity(intent);
                } else if (id == R.id.search) {
                    Intent intent = new Intent(MainActivity.this, Search.class);
                    startActivity(intent);
                } else if (id == R.id.nav_ingredient_substitutions) {
                    Intent intent = new Intent(MainActivity.this, IngredientSubs.class);
                    startActivity(intent);
                } else if (id == R.id.nav_calorie_counter) {
                    Intent intent = new Intent(MainActivity.this, CalorieCounter.class);
                    startActivity(intent);
                } else if (id == R.id.nav_pantry) {
                    Intent intent = new Intent(MainActivity.this, RecipeListings.class);
                    startActivity(intent);
                } else if (id == R.id.nav_cooking_tips) {
                    Intent intent = new Intent(MainActivity.this, CookingTips.class);
                    startActivity(intent);
                } else if (id == R.id.nav_resources) {
                    Intent intent = new Intent(MainActivity.this, Resources.class);
                    startActivity(intent);
                } else if (id == R.id.nav_settings) {
                    return false;
                }else if (id == R.id.nav_logout) {
                    mAuth.signOut();
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }else {
                    return false;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}

