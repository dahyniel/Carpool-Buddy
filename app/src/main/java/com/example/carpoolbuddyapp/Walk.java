package com.example.carpoolbuddyapp;

import java.io.Serializable;

/**
 * This class is for vehicle type Walk that a user can add
 *
 * @author danielyang
 * @version 1.0
 */
public class Walk implements Serializable
{
    String walkId;
    String walkType;
    String walkOwner;
    int walkCapacity;
    double walkPrice;
    String walkDescription;
    boolean walkStatus;

    public Walk()
    {
    }

    public Walk(String id, String type, String owner, int capacity, double price, String description, boolean status)
    {
        this.walkId = id;
        this.walkType = type;
        this.walkOwner = owner;
        this.walkCapacity = capacity;
        this.walkPrice = price;
        this.walkDescription = description;
        this.walkStatus = status;
    }

    public String getWalkId()
    {
        return walkId;
    }

    public String getWalkType()
    {
        return walkType;
    }

    public String getWalkOwner()
    {
        return walkOwner;
    }

    public int getWalkCapacity()
    {
        return walkCapacity;
    }

    public double getWalkPrice()
    {
        return walkPrice;
    }

    public String getWalkDescription()
    {
        return walkDescription;
    }

    public boolean isWalkStatus()
    {
        return walkStatus;
    }
}
