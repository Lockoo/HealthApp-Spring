package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Doctor;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;
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
    public Doctor[] getBySpeciality(String speciality)
    {
        Doctor[] doctors = new Doctor[docDAO.findBySpeciality(speciality).size()];
        int i = 0;
    
        for(Doctor doc : docDAO.findBySpeciality(speciality))
        {
            doctors[i++] = doc;
        }
        return doctors;
    }

    @Override
    public Doctor[] findAll()
    {
        Doctor[] docs = new Doctor[this.docDAO.findAll().size()];
        docs = this.docDAO.findAll().toArray(docs);
        return docs;
    }

    @Override
    public boolean doesDoctorExist(String email)
    {       
        if(this.docDAO.findByEmail(email).isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public Doctor saveDoctor(Doctor doc)
    {
        return this.docDAO.saveDoctor(doc);
    }

    @Override
    public Doctor getByEmail(String email)
    {
        return this.docDAO.findByEmail(email).get(0);
    }

    @Override
    public Doctor changeFirstName(Doctor doc, String firstName)
    {
        return this.docDAO.changeFirstName(doc, firstName);
    }
    
    @Override
    public void deleteDoctor(Doctor doctor)
    {
        this.docDAO.deleteDoctor(doctor);
    }
    
    @Override
    public Doctor isValidDoctor(String email, String password) throws UnmatchingUserCredentialsException
    {
        return this.docDAO.isValidDoctor(email, password);
    }
}
