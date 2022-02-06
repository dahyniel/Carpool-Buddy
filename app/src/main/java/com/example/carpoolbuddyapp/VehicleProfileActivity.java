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
    TextView carCapacity;
    TextView carDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        carType = findViewById(R.id.carTypeResult);
        carOwner = findViewById(R.id.carOwnerResult);
        carPrice = findViewById(R.id.carPriceResult);
        carCapacity = findViewById(R.id.carCapacityResult);
        carDescription = findViewById(R.id.carDescriptionResult);

        String type = "N/A";
        Bundle typeExtras = getIntent().getExtras();
        if (typeExtras != null)
        {
            type = typeExtras.getString("Type");
        }
        carType.setText(type);

        String owner = "N/A";
        Bundle ownerExtras = getIntent().getExtras();
        if (ownerExtras != null)
        {
            owner = ownerExtras.getString("Owner");
        }
        carOwner.setText(owner);

        String price = "N/A";
        Bundle priceExtras = getIntent().getExtras();
        if (priceExtras != null)
        {
            price = priceExtras.getString("Price");
        }
        carPrice.setText(price);

        String capacity = "N/A";
        Bundle capacityExtras = getIntent().getExtras();
        if (capacityExtras != null)
        {
            capacity = capacityExtras.getString("Capacity");
        }
        carCapacity.setText(capacity);

        String description = "N/A";
        Bundle descriptionExtras = getIntent().getExtras();
        if (descriptionExtras != null)
        {
            description = descriptionExtras.getString("Description");
        }
        carDescription.setText(description);
    }

    public void bookRide(View v)
    {
        //Reduce current capacity for this vehicle, in the database by 1.
        System.out.println("RIDE BOOKED");
    }
}