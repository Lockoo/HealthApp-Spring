package com.example.demo.services;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Doctor;
import com.example.demo.repositories.DoctorDAO;

@Service
public class DoctorServiceImpl implements DoctorService
{
    private DoctorDAO docDAO;

    @Autowired
    public DoctorServiceImpl(DoctorDAO docDAO)
    {
        this.docDAO = docDAO;

    }

    @Override
    public Doctor[] getBySpeciality()
    {
        return null;
    }

    @Override
    public Doctor[] findAll()
    {
        Doctor[] docs = new Doctor[this.docDAO.findAll().size()];
        docs = this.docDAO.findAll().toArray(docs);
        return docs;
    }
}
