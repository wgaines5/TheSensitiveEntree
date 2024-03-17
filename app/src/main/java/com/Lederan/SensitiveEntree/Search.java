package com.Lederan.SensitiveEntree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {


    // Widget variables
    SearchView search_view;
    ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_view = findViewById(R.id.search_view);
        list_view = findViewById(R.id.list_view);

        // sample data for the search to work
        String[] items = {
                "Spaghetti", "Chicken Parmesan", "Tacos", "Caesar Salad", "Grilled Cheese", "Macaroni and Cheese", "Fettuccine Alfredo", "Fried Rice", "Cookies",
                "Steak", "Garlic Bread", "Peach Cobbler", "Stir Fry", "Pulled Pork", "Burritos", "Omelet", "Parfait",
                "Cake", "Casserole"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_layout, items);
        list_view.setAdapter(adapter);

        setupSearchView();

    }

    // need to set up OnItemClicked for list_view here

    private void searchFilter(String query) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) list_view.getAdapter();
        adapter.getFilter().filter(query);
    }

    private void setupSearchView() {
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchFilter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchFilter(newText);
                return false;
            }
        });
    }
    public void onClickBack(View view){
        Intent myintent = new Intent(Search.this, RecipeListings.class);
        Search.this.startActivity(myintent);
    }

}
