package com.example.demo.services;

import com.example.demo.domain.Doctor;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;

public interface DoctorService
{
    public boolean doesDoctorExist(String email);
    
    public Doctor[] getBySpeciality(String speciality);
    
    public Doctor getByEmail(String email);
    
    public Doctor[] findAll();
    
    public Doctor saveDoctor(Doctor doc);
    
    public Doctor changeFirstName(Doctor doc, String firstName);
    
    public void deleteDoctor(Doctor doctor);
    
    public Doctor isValidDoctor(String email, String password) throws UnmatchingUserCredentialsException;
}
