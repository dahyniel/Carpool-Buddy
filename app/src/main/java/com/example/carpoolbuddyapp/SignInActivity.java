package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignInActivity extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private String selected;
    private Spinner sUserType;

    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        emailField = findViewById(R.id.signInEmailInput);
        passwordField = findViewById(R.id.signInPasswordInput);
    }

    public void signIn(View v)
    {
        System.out.println("Sign inned");
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();

        System.out.println("EMAIL HERE:" + emailString);
        System.out.println("EMAIL HERE:" + passwordString);

//        FirebaseUser mUser = mAuth.getCurrentUser();
//
//        firestore.collection("users").document();
//
//        firestore.collection("    ").document().addSnapshotListener(new OnCompleteListener<DocumentSnapshot>())
//        {
//            public void onComplete(@NonNull Task<DocumentSnapshot> task)
//            {
//                if(task.isSuccessful())
//                {
//
//                }
//                else
//                {
//
//                }
//            }
//        }
    }

    public void updateUI(FirebaseUser currentUser)
    {
        if (currentUser != null)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}