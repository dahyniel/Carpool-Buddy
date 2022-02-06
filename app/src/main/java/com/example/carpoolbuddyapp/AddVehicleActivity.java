package com.example.carpoolbuddyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.UUID;

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
        if (!formValid())
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

        String id = UUID.randomUUID().toString();

        if (typeValue.equals("Electric"))
        {
            ElectricVehicle car = new ElectricVehicle(id, typeValue, "testing owner", capacityValue, priceValue, descriptionValue, true);
            firestoreRef.collection("Electric Vehicles").document(car.getCarId()).set(car);
        }
        else if (typeValue.equals("Car"))
        {
            Vehicles car = new Vehicles(id, typeValue, "testing owner", capacityValue, priceValue, descriptionValue, true);
            firestoreRef.collection("Vehicles").document(car.getCarId()).set(car);

            firestoreRef.collection("Vehicles").document(car.getCarId()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
            {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task)
                {
                    if (task.isSuccessful())
                    {
                        DocumentSnapshot ds = task.getResult();
                        Vehicles vehicle = ds.toObject(Vehicles.class);
                        String vehicleDescription = vehicle.getCarDescription();
                    }
                }
            });
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
        if (carType.getText().equals(" ") || carCapacity.getText().equals(" ") ||
                carPrice.getText().equals(" ") || carDescription.getText().equals(" "))
        {
            return false;
        }
        return true;
    }
}