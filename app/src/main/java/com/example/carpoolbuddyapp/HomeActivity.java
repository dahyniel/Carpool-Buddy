package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity
{
    Button myVehiclesButton;
    Button bookRideButton;
    Button greenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myVehiclesButton = findViewById(R.id.homeMyVehiclesButton);
        myVehiclesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openUserProfileActivity();
            }
        });

        bookRideButton = findViewById(R.id.homeBookRideButton);
        bookRideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openMyVehiclesActivity();
            }
        });

        greenButton = findViewById(R.id.homeGreenButton);
        greenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openGreenActivity();
            }
        });
    }

    public void openUserProfileActivity()
    {
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    public void openMyVehiclesActivity()
    {
        Intent intent = new Intent(this, VehiclesInfoActivity.class);
        startActivity(intent);
    }

    public void openGreenActivity()
    {
        Intent intent = new Intent(this, GreenActivity.class);
        startActivity(intent);
    }
}