package com.example.demo.services;

import com.example.demo.domain.Doctor;

public interface DoctorService
{
    public Doctor[] getBySpeciality();
    
    public Doctor[] findAll();
}
