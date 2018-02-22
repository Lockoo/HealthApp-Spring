package com.example.demo.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Doctor;

@Repository
@Transactional()
public class DoctorDAOImpl implements DoctorDAO
{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Doctor> findBySpeciality(String speciality)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findBySpeciality");
        query.setParameter("speciality", speciality);
        return query.list();
    }


    @Override
    public List<Doctor> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findAll");
        return query.list();
    }


    @Override
    public List<Doctor> findByEmail(String email)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findDocByEmail");
        query.setString("email", email);
        return query.list();
    }


    @Override
    public Doctor saveDoctor(Doctor doc)
    {
        Session session = this.sessionFactory.openSession();
        session.save(doc);
        session.close();
        return doc;
    }


    @Override
    public Doctor changeFirstName(Doctor doc, String firstName)
    {
        Session session = this.sessionFactory.openSession();
        Query query = session.getNamedQuery("changeDocFirstName");
        query.setParameter("email", doc.getEmail());
        query.setParameter("firstName", firstName);
        query.executeUpdate();
        
        Query queryReturn = session.getNamedQuery("findDocByEmail");
        queryReturn.setParameter("email", doc.getEmail());
        return (Doctor) queryReturn.list().get(0);
    }

}
