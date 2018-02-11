package com.example.demo.helpers;

import com.example.demo.domain.User;

public class User_Json
{   
    public String firstName;
        
    public String email;
    
    public int role;
    
    
    public User_Json(User user)
    {
        this.firstName = new String(user.getFirstName());
        this.email = new String(user.getEmail());
        this.role = new Integer(user.getRole());
    }
}
