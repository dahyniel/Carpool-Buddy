package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class VehiclesInfoActivity extends AppCompatActivity
{
    Button vehicleInfoButton;
    FirebaseAuth mAuth;
    FirebaseUser user;
    Vehicles vehicleInfo;
    ArrayList<Vehicles> vehiclesList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);

        vehicleInfoButton = findViewById(R.id.infoButton);
        vehicleInfoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openVehicleInfoActivity();
            }
        });
    }

    public void openVehicleInfoActivity()
    {
        Intent intent = new Intent(this, VehicleProfileActivity.class);
        startActivity(intent);
    }

    public void getAndPopulateData()
    {
        //Get all of the vehicles from the database that are open.
        //Use document.toObject(Vehicle.class). This will deserialize the contents of the database information and give you a Vehicle object. Add all vehicles to the vehicles ArrayList.
        //On completion of task for fetching all vehicles, set new RecyclerViewAdapter with the list of vehicles fetched.
    }
}