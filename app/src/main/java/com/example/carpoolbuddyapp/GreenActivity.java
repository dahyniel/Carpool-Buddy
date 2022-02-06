package com.example.carpoolbuddyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class GreenActivity extends AppCompatActivity
{
    private ArrayList<RecyclerViewUser> carIdList;
    private ArrayList<RecyclerViewUser> carTypeList;
    private ArrayList<RecyclerViewUser> carOwnerList;
    private ArrayList<RecyclerViewUser> carPriceList;
    private ArrayList<RecyclerViewUser> carCapacityList;
    private ArrayList<RecyclerViewUser> carDescriptionList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green);
        carIdList = new ArrayList<>();
        carTypeList = new ArrayList<>();
        carOwnerList = new ArrayList<>();
        carPriceList = new ArrayList<>();
        carCapacityList = new ArrayList<>();
        carDescriptionList = new ArrayList<>();
        recyclerView = findViewById(R.id.greenRecyclerView);
        firestore = FirebaseFirestore.getInstance();
        setUserInfo();
    }

    private void setAdapter()
    {
        setOnClickListener();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(carDescriptionList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener()
    {
        listener = new RecyclerViewAdapter.RecyclerViewClickListener()
        {
            @Override
            public void onClick(View v, int position)
            {
                Intent intent = new Intent(getApplicationContext(), GreenVehicleProfileActivity.class);
                intent.putExtra("Id", carIdList.get(position).getUsername());
                intent.putExtra("Type", carTypeList.get(position).getUsername());
                intent.putExtra("Owner", carOwnerList.get(position).getUsername());
                intent.putExtra("Price", carPriceList.get(position).getUsername());
                intent.putExtra("Capacity", carCapacityList.get(position).getUsername());
                intent.putExtra("Description", carDescriptionList.get(position)
                        .getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo()
    {
        firestore.collection("Electric Vehicles")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot document: task.getResult())
                    {
                        String id = document.toObject(ElectricVehicle.class).getCarId();
                        carIdList.add(new RecyclerViewUser(id));

                        String type = document.toObject(ElectricVehicle.class).getCarType();
                        carTypeList.add(new RecyclerViewUser(type));

                        String owner = document.toObject(ElectricVehicle.class).getCarOwner();
                        carOwnerList.add(new RecyclerViewUser(owner));

                        double price = document.toObject(ElectricVehicle.class).getCarPrice();
                        String priceString = Double.toString(price);
                        carPriceList.add(new RecyclerViewUser(priceString));

                        int capacity = document.toObject(ElectricVehicle.class).getCarCapacity();
                        String capacityString = Integer.toString(capacity);
                        carCapacityList.add(new RecyclerViewUser(capacityString));

                        String description = document.toObject(ElectricVehicle.class).getCarDescription();
                        carDescriptionList.add(new RecyclerViewUser(description));
                    }
                }
                setAdapter();
            }
        });
    }
}