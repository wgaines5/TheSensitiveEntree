package com.Lederan.SensitiveEntree;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class IngredientSubs extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sub1_spinner, sub2_spinner, sub3_spinner, sub4_spinner;
    String[] subsOne = {"Substitution 1", "Substitution 2", "Substitution 3", "Substitution 4"};
    AutoCompleteTextView autocompletetextview;
    ArrayAdapter<String> subItems;
    private static final String[] subs1 = {"Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs2 = {"Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs3 = {"Sub 1", "Sub 2", "Sub 3"};
    private static final String[] subs4 = {"Sub 1", "Sub 2", "Sub 3"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_subs);

        //Dropdown #1
        sub1_spinner = (Spinner)findViewById(R.id.sub1_spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                android.R.layout.simple_spinner_item,subs1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub1_spinner.setAdapter(adapter);
        sub1_spinner.setOnItemSelectedListener(this);

        //Dropdown #2
        sub2_spinner = (Spinner)findViewById(R.id.sub2_spinner);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                android.R.layout.simple_spinner_item,subs2);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub2_spinner.setAdapter(adapter);
        sub2_spinner.setOnItemSelectedListener(this);

        //Dropdown #3
        sub3_spinner = (Spinner)findViewById(R.id.sub3_spinner);
        ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                android.R.layout.simple_spinner_item,subs3);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub3_spinner.setAdapter(adapter);
        sub3_spinner.setOnItemSelectedListener(this);

        //Dropdown #4
        sub4_spinner = (Spinner)findViewById(R.id.sub4_spinner);
        ArrayAdapter<String>adapter4 = new ArrayAdapter<String>(com.Lederan.SensitiveEntree.IngredientSubs.this,
                android.R.layout.simple_spinner_item,subs4);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub4_spinner.setAdapter(adapter);
        sub4_spinner.setOnItemSelectedListener(this);

    }
    public void onClickBack(View view){
        Intent myintent = new Intent(com.Lederan.SensitiveEntree.IngredientSubs.this, RecipeDetails.class);
        com.Lederan.SensitiveEntree.IngredientSubs.this.startActivity(myintent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
