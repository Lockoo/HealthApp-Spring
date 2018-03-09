package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domain.Doctor;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;

public interface DoctorDAO
{
    public List<Doctor> findByEmail(String email);
    
    public List<Doctor> findBySpeciality(String speciality);
    
    public List<Doctor> findAll();
    
    public Doctor saveDoctor(Doctor doc);
    
    public Doctor changeFirstName(Doctor doc, String firstName);
    
    public void deleteDoctor(Doctor doc);
    
    public Doctor isValidDoctor(String email, String password) throws UnmatchingUserCredentialsException;
}
