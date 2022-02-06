package com.example.carpoolbuddyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class VehiclesInfoActivity extends AppCompatActivity
{
    private ArrayList<RecyclerViewUser> usersList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;

    FirebaseFirestore firestore;
    FirebaseAuth mAuth;
    FirebaseUser user;
    Vehicles vehicleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);
        usersList = new ArrayList<>();
        recyclerView = findViewById(R.id.myVehiclesRecyclerView);
        firestore = FirebaseFirestore.getInstance();
        setUserInfo();
    }

    private void setAdapter()
    {
        setOnClickListener();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(usersList, listener);
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
                Intent intent = new Intent(getApplicationContext(), VehicleProfileActivity.class);
                intent.putExtra("Description", usersList.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo()
    {
        firestore.collection("Vehicles").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot document: task.getResult())
                    {
                        String description = document.toObject(Vehicles.class).getCarDescription();
                        usersList.add(new RecyclerViewUser(description));
                    }
                }
                setAdapter();
            }
        });
    }

    public void openVehicleInfoActivity(View v)
    {
        Intent intent = new Intent(this, VehicleProfileActivity.class);
        startActivity(intent);
    }
}