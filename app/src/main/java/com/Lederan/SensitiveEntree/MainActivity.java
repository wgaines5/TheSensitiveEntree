package com.Lederan.SensitiveEntree;

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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MainActivity extends AppCompatActivity  {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    ImageView feat1;
    ImageView feat2;
    ImageView feat3;
    ImageView feat4;
    ImageView feat5;

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
        FirebaseStorage storage = FirebaseStorage.getInstance();

        //==================================================================================
        // For hamburger control
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        sidbarNav();
        //=================================================================================
        // Renders the features from firebase
        feat1 = findViewById(R.id.feat1);
        feat2 = findViewById(R.id.feat2);
        feat3 = findViewById(R.id.feat3);
        feat4 = findViewById(R.id.feat4);
        feat5 = findViewById(R.id.feat5);
        Bok(storage);
        ChickenParm(storage);
        Spaghetti(storage);
        Steak(storage);
        Swordfish(storage);
        //==================================================================================
    }
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

    public void Bok(FirebaseStorage storage)
    {
        StorageReference storageRef = storage.getReference().child("Food").child("del119923-bok-choy-web-139-rv-index-6567f49581973.jpg");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into ImageView using Glide
                Glide.with(MainActivity.this)
                        .load(uri)
                        .apply(RequestOptions.circleCropTransform()) // Apply transformations if needed
                        .into(feat1);
            }
        });

        ImageView imageView = findViewById(R.id.feat1);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RecipeListings.class);
                startActivity(intent);
            }
        });
    }

    public void ChickenParm(FirebaseStorage storage)
    {
        StorageReference storageRef = storage.getReference().child("Food").child("Chicken-Parmesan-Recipe-f-500x500.webp");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into ImageView using Glide
                Glide.with(MainActivity.this)
                        .load(uri)
                        .apply(RequestOptions.circleCropTransform()) // Apply transformations if needed
                        .into(feat2);
            }
        });

        ImageView imageView = findViewById(R.id.feat2);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                startActivity(intent);
            }
        });
    }

    public void Spaghetti(FirebaseStorage storage)
    {
        StorageReference storageRef = storage.getReference().child("Food").child("Spaghetti-with-Meat-Sauce-Recipe-1-1200.jpg");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into ImageView using Glide
                Glide.with(MainActivity.this)
                        .load(uri)
                        .apply(RequestOptions.circleCropTransform()) // Apply transformations if needed
                        .into(feat3);
            }
        });

        ImageView imageView = findViewById(R.id.feat3);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, BakedSpaghetti.class);
                startActivity(intent);
            }
        });
    }

    public void Steak(FirebaseStorage storage)
    {
        StorageReference storageRef = storage.getReference().child("Food").child("grilled-steak-15.jpg");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into ImageView using Glide
                Glide.with(MainActivity.this)
                        .load(uri)
                        .apply(RequestOptions.circleCropTransform()) // Apply transformations if needed
                        .into(feat4);
            }
        });

        ImageView imageView = findViewById(R.id.feat4);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                startActivity(intent);
            }
        });
    }

    public void Swordfish(FirebaseStorage storage)
    {
        StorageReference storageRef = storage.getReference().child("Food").child("grilled-swordfish-11.jpg");
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image into ImageView using Glide
                Glide.with(MainActivity.this)
                        .load(uri)
                        .apply(RequestOptions.circleCropTransform()) // Apply transformations if needed
                        .into(feat5);
            }
        });

        ImageView imageView = findViewById(R.id.feat5);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RecipeDetails.class);
                startActivity(intent);
            }
        });
    }

    public void onClickBakedSpaghetti(View view){
        Intent myintent = new Intent(MainActivity.this, BakedSpaghetti.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickBeansBourguignon(View view){
        Intent myintent = new Intent(MainActivity.this, BeansBourguignon.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickBeefAndPolenta(View view){
        Intent myintent = new Intent(MainActivity.this, BeefAndPolenta.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickBokChoy(View view){
        Intent myintent = new Intent(MainActivity.this, BokChoy.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickCauliflowerSoup(View view){
        Intent myintent = new Intent(MainActivity.this, CauliflowerSoup.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickChickenPie(View view){
        Intent myintent = new Intent(MainActivity.this, ChickenPie.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickChickenTacos(View view){
        Intent myintent = new Intent(MainActivity.this, ChickenTacos.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickCreamyShrimpSkillet(View view){
        Intent myintent = new Intent(MainActivity.this, CreamyShrimpSkillet.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickDeviledCrabs(View view){
        Intent myintent = new Intent(MainActivity.this, DeviledCrabs.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickDrunkenNoodles(View view){
        Intent myintent = new Intent(MainActivity.this, DrunkenNoodles.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickLambChops(View view){
        Intent myintent = new Intent(MainActivity.this, LambChops.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickLambScewers(View view){
        Intent myintent = new Intent(MainActivity.this, LambScewers.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickMustardRoastedFish(View view){
        Intent myintent = new Intent(MainActivity.this, MustardRoastedFish.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickPanPizza(View view){
        Intent myintent = new Intent(MainActivity.this, PanPizza.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickPeanutChocolate(View view){
        Intent myintent = new Intent(MainActivity.this, PeanutChocolate.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickPotRoast(View view){
        Intent myintent = new Intent(MainActivity.this, PotRoast.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickRoastedHalibut(View view){
        Intent myintent = new Intent(MainActivity.this, RoastedHalibut.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickShrimpScampi(View view){
        Intent myintent = new Intent(MainActivity.this, ShrimpScampi.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickVegtableLinguine(View view){
        Intent myintent = new Intent(MainActivity.this, VegtableLinguine.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickTumericChickenFlatbread(View view){
        Intent myintent = new Intent(MainActivity.this, ChickenFlatbread.class);
        MainActivity.this.startActivity(myintent);
    }
    public void onClickVeganTostadas(View view){
        Intent myintent = new Intent(MainActivity.this, VeganTostadas.class);
        MainActivity.this.startActivity(myintent);
    }
}

