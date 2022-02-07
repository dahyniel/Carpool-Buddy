package com.example.carpoolbuddyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * This class is for users to view information about a vehicle
 *
 * @author danielyang
 * @version 1.0
 */
public class VehicleProfileActivity extends AppCompatActivity
{
    TextView carId;
    TextView carType;
    TextView carOwner;
    TextView carPrice;
    TextView carCapacity;
    TextView carDescription;
    FirebaseFirestore firestore;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        firestore = FirebaseFirestore.getInstance();
        carId = findViewById(R.id.carIDResult);
        carType = findViewById(R.id.carTypeResult);
        carOwner = findViewById(R.id.carOwnerResult);
        carPrice = findViewById(R.id.carPriceResult);
        carCapacity = findViewById(R.id.carCapacityResult);
        carDescription = findViewById(R.id.carDescriptionResult);

        mAuth = FirebaseAuth.getInstance();

        String setId = "N/A";
        Bundle idExtras = getIntent().getExtras();
        if (idExtras != null)
        {
            setId = idExtras.getString("Id");
        }
        carId.setText(setId);

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

    /**
     * This method allows users to book a ride
     * @param v sends a success message to the user if the ride is booked
     */
    public void bookRide(View v)
    {
        String checkOwner = mAuth.getCurrentUser().getEmail();
        checkOwner = checkOwner.substring(0, checkOwner.length() - 10);

        String capacity = carCapacity.getText().toString();
        int capacityInt = Integer.parseInt(capacity);
        Log.d("INT TEST", capacity);

        String price = carPrice.getText().toString();
        double priceDouble = Double.parseDouble(price);
        Log.d("DOUBLE TEST", price);

        if (!checkOwner.equals(carOwner.getText()))
        {
            Vehicles car = new Vehicles(carId.getText().toString(), carType.getText().toString(), carOwner.getText().toString(), capacityInt - 1, priceDouble,
                    carDescription.getText().toString(), true);
            firestore.collection("Vehicles").document(car.getCarId()).set(car);

            Context context = getApplicationContext();
            CharSequence text = "Ride booked!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "You can't book your own vehicle!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void closeCar(View v)
    {
        String checkOwner = mAuth.getCurrentUser().getEmail();
        checkOwner = checkOwner.substring(0, checkOwner.length() - 10);

        String capacity = carCapacity.getText().toString();
        int capacityInt = Integer.valueOf(capacity);

        String price = carPrice.getText().toString();
        double priceDouble = Double.valueOf(price);

        if (checkOwner.equals(carOwner.getText().toString()))
        {
            Vehicles car = new Vehicles(carId.getText().toString(), carType.getText().toString(), carOwner.getText().toString(), capacityInt, priceDouble,
                    carDescription.getText().toString(), false);
            firestore.collection("Vehicles").document(car.getCarId()).set(car);

            Context context = getApplicationContext();
            CharSequence text = "Vehicle closed!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "You cannot close the vehicle!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}