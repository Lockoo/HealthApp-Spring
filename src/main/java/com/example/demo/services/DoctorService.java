package com.example.demo.services;

import com.example.demo.domain.Doctor;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;
import com.example.demo.exceptions.UserNotFoundException;

public interface DoctorService
{    
    public Doctor[] getBySpeciality(String speciality);
    
    public Doctor getByEmail(String email) throws UserNotFoundException;
    
    public Doctor[] findAll();
    
    public Doctor saveDoctor(Doctor doc);
    
    public Doctor changeFirstName(Doctor doc, String firstName);
    
    public void deleteDoctor(Doctor doctor);
    
    public Doctor isValidDoctor(String email, String password) throws UnmatchingUserCredentialsException;
}
