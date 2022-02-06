package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button signInButtom;
    Button signUpButtom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButtom = findViewById(R.id.enterSignInPageButton);
        signInButtom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openSignInActivity();
            }
        });

        signUpButtom = findViewById(R.id.enterSignUpPageButton);
        signUpButtom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openSignUpActivity();
            }
        });
    }

    public void openSignInActivity()
    {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void openSignUpActivity()
    {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}