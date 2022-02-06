package com.example.carpoolbuddyapp;

import java.io.Serializable;

public class ElectricVehicle implements Serializable
{
    String carType;
    String carOwner;
    int carCapacity;
    double carPrice;
    String carDescription;
    boolean carStatus;

    public ElectricVehicle()
    {
    }

    public ElectricVehicle(String type, String owner, int capacity, double price, String description, boolean status)
    {
        this.carType = type;
        this.carOwner = owner;
        this.carCapacity = capacity;
        this.carPrice = price;
        this.carDescription = description;
        this.carStatus = status;
    }

    public String getCarType()
    {
        return carType;
    }

    public String getCarOwner()
    {
        return carOwner;
    }

    public int getCarCapacity()
    {
        return carCapacity;
    }

    public double getCarPrice()
    {
        return carPrice;
    }

    public String getCarDescription()
    {
        return carDescription;
    }

    public boolean isCarStatus()
    {
        return carStatus;
    }
}