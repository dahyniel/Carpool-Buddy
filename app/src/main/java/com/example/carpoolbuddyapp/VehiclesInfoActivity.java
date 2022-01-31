package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VehiclesInfoActivity extends AppCompatActivity
{
    Button vehicleInfoButton;

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
}