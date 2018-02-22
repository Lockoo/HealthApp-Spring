package com.example.demo.helpers;

import com.example.demo.domain.Doctor;
import com.example.demo.domain.User;

public class User_Json
{   
    public String firstName, lastName, email, password, speciality;
    
    public int role;

    public User_Json()
    {
        
    }
    
    public User_Json(String firstName, String lastName, String email, String password, int role)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.speciality = null;
    }
    
    public User_Json(String firstName, String lastName, String email, String password, int role, String speciality)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.speciality = speciality;
    }
    
    public User_Json(User user)
    {
        this.lastName = new String(user.getLastName());
        this.firstName = new String(user.getFirstName());
        this.email = new String(user.getEmail());
        this.password = new String(user.getPassword());
        this.role = new Integer(user.getRole());
        this.speciality = null;
    }
    
    public User_Json(Doctor doc)
    {
        this.lastName = new String(doc.getLastName());
        this.firstName = new String(doc.getFirstName());
        this.email = new String(doc.getEmail());
        this.password = new String(doc.getPassword());
        this.role = 1;
        this.speciality = new String(doc.getSpeciality());
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastname)
    {
        this.lastName = lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public String getSpeciality()
    {
        return speciality;
    }

    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }
    
    
}
