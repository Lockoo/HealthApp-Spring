package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Doctor;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;

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


    @SuppressWarnings("unchecked")
    @Override
    public List<Doctor> findAll()
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findAll");
        return query.list();
    }


    @SuppressWarnings("unchecked")
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
    
    @Override
    public void deleteDoctor(Doctor doctor)
    {
        Session session = this.sessionFactory.openSession();
        Query query = session.getNamedQuery("deleteDoctor");
        query.setParameter("email", doctor.getEmail());
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public Doctor isValidDoctor(String email, String password) throws UnmatchingUserCredentialsException
    {
        Session session = this.sessionFactory.openSession();
        Query query = session.getNamedQuery("findDocByEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        ArrayList<Object> queryList = new ArrayList<Object>(query.list());
        if(queryList.isEmpty())
        {
            throw new UnmatchingUserCredentialsException("No Doctor Account found for this combination");
        }
        else
        {
            return (Doctor) queryList.get(0);
        }
        
    }

}
