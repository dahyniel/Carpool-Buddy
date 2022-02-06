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

//        Bundle extras = getIntent().getExtras();
//        if (extras != null)
//        {
//            username = extras.getString("username");
//        }

        carType.setText("username");

        //type = db.getType etc. for rest
    }

    public void bookRide(View v)
    {
        //Reduce current capacity for this vehicle, in the database by 1.
        System.out.println("RIDE BOOKED");
    }
}