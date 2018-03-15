package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.UserDAO;

@Service
public class UserServiceImpl implements UserService
{
    // UserDAO service
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    @Override
    public long findCount()
    {
        return userDAO.findAllCount();
    }

    @Override
    public User save(User user)
    {
        return userDAO.save(user);
    }

    @Override
    public void update(User user)
    {

    }

    @Override
    public User doesUserExist(String email) throws UserNotFoundException
    {
        if(userDAO.findByEmail(email).isEmpty())
        {
            throw new UserNotFoundException("User does not exist in the database.");
        }
        else
        {
            User user = userDAO.findByEmail(email).get(0);
            return user;
        }
    }


    @Override
    public User isValidUser(String email, String password) throws UnmatchingUserCredentialsException
    {
        List<User> users = (List<User>) userDAO.findByEmailAndPassword(email, password); 
        if(users == null || users.size() == 0) { 
          throw new UnmatchingUserCredentialsException("User with given credentials is not found in the database."); 
        }  
        return users.get(0); 
    }

}
