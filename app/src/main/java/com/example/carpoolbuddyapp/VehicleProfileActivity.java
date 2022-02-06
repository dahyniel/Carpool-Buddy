package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class VehicleProfileActivity extends AppCompatActivity
{
    TextView carId;
    TextView carType;
    TextView carOwner;
    TextView carPrice;
    TextView carCapacity;
    TextView carDescription;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        firestore = FirebaseFirestore.getInstance();
        carId = findViewById(R.id.carId);
        carType = findViewById(R.id.carTypeResult);
        carOwner = findViewById(R.id.carOwnerResult);
        carPrice = findViewById(R.id.carPriceResult);
        carCapacity = findViewById(R.id.carCapacityResult);
        carDescription = findViewById(R.id.carDescriptionResult);

        String setId = "N/A";
        Bundle idExtras = getIntent().getExtras();
        if (idExtras != null)
        {
            setId = idExtras.getString("Id");
        }
//        carId.setText(setId);

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
        carCapacity.setText(capacity.substring(1));

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
//        if (carType.equals("Car"))
//        {
//            Vehicles car = new Vehicles(carType, carOwner, carCapacity, carPrice,
//                    carDescription, true);
//            firestore.collection("Vehicles").document(car.getCarId()).set(car);
//        }

        Context context = getApplicationContext();
        CharSequence text = "Ride booked";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}