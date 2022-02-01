package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VehicleProfileActivity extends AppCompatActivity
{
    Button bookRideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);

        bookRideButton = findViewById(R.id.bookVehicleButton);
        bookRideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                bookRide();
            }
        });
    }

    public void bookRide()
    {
        System.out.println("RIDE BOOKED");
    }
}