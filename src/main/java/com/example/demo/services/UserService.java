package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;
import com.example.demo.exceptions.UserNotFoundException;

public interface UserService
{
    User save(User user);
    
    void update(User user);
    
    User doesUserExist(String email) throws UserNotFoundException;
    
    User getByEmail(String email) throws UserNotFoundException;
    
    User isValidUser(String email, String password) throws UnmatchingUserCredentialsException;
    
    long findCount();
}
