package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VehicleProfileActivity extends AppCompatActivity
{
    Button bookRideButton;
    FirebaseAuth mAuth;
    FirebaseUser user;
    Vehicles vehicleInfo;

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

    public void setUpButton()
    {
        //Only shows “book ride” button if this user is not the owner of this vehicle.
        //Show the correct price in a label depending on the user’s role.
        //Teachers and students pay half price. Alumni and Parents pay full price.
        //Only shows “open/close” button if the user IS the owner of this vehicle.
    }

    public void bookRide()
    {
        //Reduce current capacity for this vehicle, in the database by 1.
        System.out.println("RIDE BOOKED");
    }
}