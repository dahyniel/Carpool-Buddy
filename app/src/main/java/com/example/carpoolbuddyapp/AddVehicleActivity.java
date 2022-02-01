package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity
{
    Button addVehicleButton;
    EditText carName;
    EditText carCapacity;
    EditText carPrice;
    EditText carDescription;

    FirebaseFirestore firestoreRef;
    FirebaseUser mUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        carName = findViewById(R.id.carNameResult);
        carCapacity = findViewById(R.id.carCapacityResult);
        carPrice = findViewById(R.id.carPriceResult);
        carDescription = findViewById(R.id.carDescriptionResult);

        firestoreRef = FirebaseFirestore.getInstance();
        //firestore.collection(“/somepath”).set(someObject) will save the object to the database.

        mAuth = FirebaseAuth.getInstance();

        addVehicleButton = findViewById(R.id.addVehicleButton);
        addVehicleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addNewVehicle();
            }
        });
    }

    public void addNewVehicle()
    {
        if (formValid() == false)
        {
            Context context = getApplicationContext();
            CharSequence text = "Fill in all sections";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //Check the type of vehicle chosen, use the database reference to store the vehicle subclass instance. If a user adds a Car, upload a Car object, if user adds an Electric Car upload an ElectricCar object.
        System.out.println("ADDED VEHICLE");
    }

    public boolean formValid()
    {
        if (carName.getText().equals(" ") || carCapacity.getText().equals(" ") ||
                carPrice.getText().equals(" ") || carDescription.getText().equals(" "))
        {
            return false;
        }
        return true;
    }
}