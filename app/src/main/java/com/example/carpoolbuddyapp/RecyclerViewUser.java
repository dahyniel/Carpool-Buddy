package com.example.carpoolbuddyapp;

/**
 * This class is for the recycler view to display each vehicle available
 *
 * @author danielyang
 * @version 1.0
 */
public class RecyclerViewUser
{
    String username;

    public RecyclerViewUser(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
