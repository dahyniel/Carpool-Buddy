package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddVehicleActivity extends AppCompatActivity
{
    Button addVehicleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        addVehicleButton = findViewById(R.id.addVehicleButton);
        addVehicleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addVehicle();
            }
        });
    }

    public void addVehicle()
    {
        System.out.println("ADDED VEHICLE");
    }
}