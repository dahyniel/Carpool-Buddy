package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VehicleProfileActivity extends AppCompatActivity
{
    TextView carType;
    TextView carOwner;
    TextView carPrice;
    TextView carDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        carType = findViewById(R.id.carTypeResult);
        carOwner = findViewById(R.id.carOwnerResult);
        carPrice = findViewById(R.id.carPriceResult);
        carDescription = findViewById(R.id.carDescriptionResult);

        String description = "No description";
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            description = extras.getString("Description");
        }
        carDescription.setText(description);
    }

    public void bookRide(View v)
    {
        //Reduce current capacity for this vehicle, in the database by 1.
        System.out.println("RIDE BOOKED");
    }
}