package com.example.demo.services;

import com.example.demo.domain.Doctor;

public interface DoctorService
{
    public boolean doesDoctorExist(String email);
    
    public Doctor[] getBySpeciality(String speciality);
    
    public Doctor getByEmail(String email);
    
    public Doctor[] findAll();
    
    public Doctor saveDoctor(Doctor doc);
    
    public Doctor changeFirstName(Doctor doc, String firstName);
}
