package com.example.carpoolbuddyapp;

import java.io.Serializable;

public class User implements Serializable
{
    String userName;
    String userPassword;
    String userEmail;
    String userRole;

    public User()
    {
    }

    public User(String name, String password, String email)
    {
        this.userName = name;
        this.userPassword = password;
        this.userEmail = email;
//        this.userRole = role;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public String getUserRole()
    {
        return userRole;
    }
}
