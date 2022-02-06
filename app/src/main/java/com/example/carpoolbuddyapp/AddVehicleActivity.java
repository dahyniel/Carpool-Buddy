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
    EditText carType;
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

        carType = findViewById(R.id.carTypeResult);
        carCapacity = findViewById(R.id.carCapacityResult);
        carPrice = findViewById(R.id.carPriceResult);
        carDescription = findViewById(R.id.carDescriptionResult);

        firestoreRef = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
    }

    public void addNewVehicle(View v)
    {
        if (formValid() == false)
        {
            Context context = getApplicationContext();
            CharSequence text = "Fill in all sections";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        EditText type = findViewById(R.id.carTypeResult);
        String typeValue = type.getText().toString();

        EditText capacity = findViewById(R.id.carCapacityResult);
        Integer capacityValue = Integer.valueOf(capacity.getText().toString());

        EditText price = findViewById(R.id.carPriceResult);
        Double priceValue = Double.valueOf(price.getText().toString());

        EditText description = findViewById(R.id.carDescriptionResult);
        String descriptionValue = description.getText().toString();

        if (typeValue.equals("Electric"))
        {
            ElectricVehicle car = new ElectricVehicle(typeValue, "test", capacityValue, priceValue, descriptionValue, true);
            firestoreRef.collection("Vehicles").document("Electric").set(car);
        }
        else if (typeValue.equals("Car"))
        {
            Vehicles car = new Vehicles(typeValue, "test", capacityValue, priceValue, descriptionValue, true);
            firestoreRef.collection("Vehicles").document("Normal").set(car);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Invalid car type";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public boolean formValid()
    {
        if (carType.getText().equals(null) || carCapacity.getText().equals(null) ||
                carPrice.getText().equals(null) || carDescription.getText().equals(null))
        {
            return false;
        }
        return true;
    }
}