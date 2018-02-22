package com.example.demo.services;

import com.example.demo.domain.Doctor;

public interface DoctorService
{
    public boolean doesDoctorExist(String email);
    
    public Doctor[] getBySpeciality(String speciality);
    
    public Doctor[] findAll();
    
    public Doctor saveDoctor(Doctor doc);
}
