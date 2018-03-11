package com.example.demo.repositories;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;

@Repository
@Transactional()
public class UserDAOImpl implements UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    @Override
    public List<User> findByEmailAndPassword(String email, String password)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findByEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.list();
    }

    //TODO could throw nullpointer
    @SuppressWarnings(
    { "rawtypes" })
    @Override
    public long findAllCount()
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findAllCount");
        long count = (long) query.list().get(0);
        System.out.println(count);
        return count;
    }

    @SuppressWarnings(
    { "unchecked", "deprecation", "rawtypes" })
    @Override
    public List<User> findByEmail(String email)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findByEmail");
        query.setString("email", email);
        return query.list();
    }

    @Override
    public User save(User user)
    {
        Session session = this.sessionFactory.openSession();
        session.save(user);
        session.close();
        return user;
    }

    // For dynamic creation of queries at runtime use Criteria API

}
