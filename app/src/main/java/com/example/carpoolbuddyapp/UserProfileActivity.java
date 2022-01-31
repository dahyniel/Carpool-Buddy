package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserProfileActivity extends AppCompatActivity
{
    Button addVehicleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        addVehicleButton = findViewById(R.id.homeMyVehiclesButton);
        addVehicleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openAddVehicleActivity();
            }
        });
    }

    public void openAddVehicleActivity()
    {
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
    }
}