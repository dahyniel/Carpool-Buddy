package com.example.carpoolbuddyapp;

import java.io.Serializable;

public class Bicycle implements Serializable
{
    String bikeId;
    String bikeType;
    String bikeOwner;
    int bikeCapacity;
    double bikePrice;
    String bikeDescription;
    boolean bikeStatus;

    public Bicycle()
    {
    }

    public Bicycle(String id, String type, String owner, int capacity, double price, String description, boolean status)
    {
        this.bikeId = id;
        this.bikeType = type;
        this.bikeOwner = owner;
        this.bikeCapacity = capacity;
        this.bikePrice = price;
        this.bikeDescription = description;
        this.bikeStatus = status;
    }

    public String getBikeId()
    {
        return bikeId;
    }

    public String getBikeType()
    {
        return bikeType;
    }

    public String getBikeOwner()
    {
        return bikeOwner;
    }

    public int getBikeCapacity()
    {
        return bikeCapacity;
    }

    public double getBikePrice()
    {
        return bikePrice;
    }

    public String getBikeDescription()
    {
        return bikeDescription;
    }

    public boolean isBikeStatus()
    {
        return bikeStatus;
    }
}
