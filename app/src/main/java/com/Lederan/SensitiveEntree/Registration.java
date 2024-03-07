package com.Lederan.SensitiveEntree;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextConfirmation, getFName, getLName;
    Button buttonReg;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextEmail = findViewById(R.id.getEmail);
        editTextPassword = findViewById(R.id.getPassword);
        editTextConfirmation = findViewById(R.id.getConfirmPassword);
        getFName = findViewById(R.id.getFirstName);
        getLName = findViewById(R.id.getLastName);

        buttonReg = findViewById(R.id.registrationButton);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
    }

    public void onClickBack(View view) {
        Intent myIntent = new Intent(Registration.this, Login.class);
        Registration.this.startActivity(myIntent);
    }

    public void onClick(View view)
    {
        String email, password;
        email = String.valueOf(editTextEmail.getText());
        password = String.valueOf(editTextPassword.getText());
        String fName = getFName.getText().toString();
        String lName = getLName.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(Registration.this, "Enter mail", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(Registration.this, "Enter password", Toast.LENGTH_SHORT).show();
        }
        if (editTextPassword != editTextConfirmation) {
            Toast.makeText(Registration.this, "Password mismatch",
                    Toast.LENGTH_SHORT).show();
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(Registration.this, "Account created! ",
                            Toast.LENGTH_SHORT).show();


                    //Adds the user Information to the database
                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fStore.collection("users").document(userID);
                    Map<String, Object> userMap = new HashMap<>();
                    userMap.put("First Name", fName);
                    userMap.put("Last Name", lName);
                    documentReference.set(userMap).addOnSuccessListener(aVoid ->
                    {
                        System.out.println("Completed");
                    }).addOnFailureListener(e ->
                    {
                        System.out.println("Failed");
                    });

                    //Takes you to the homepage
                    startActivity(new Intent(Registration.this, MainActivity.class));
                }
                else
                {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(Registration.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}