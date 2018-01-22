package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domain.Doctor;

public interface DoctorDAO
{
    public List<Doctor> findBySpeciality(String speciality);
    
    public List<Doctor> findAll();
}
