package com.example.demo.helpers;

import com.example.demo.domain.Doctor;

public class UpdatedDoc
{
    private Doctor doc;
    
    private String firstName;
    
    public UpdatedDoc()
    {
        
    }

    public Doctor getDoc()
    {
        return doc;
    }

    public void setDoc(Doctor doc)
    {
        this.doc = doc;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
}
