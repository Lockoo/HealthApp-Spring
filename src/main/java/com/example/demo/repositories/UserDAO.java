package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domain.User;
import com.example.demo.exceptions.UserNotFoundException;

public interface UserDAO
{
    public List<User> findByEmail(String email);
    
    User save(User user);
    
    long findAllCount();
    
    public List<User> findByEmailAndPassword(String email, String password);
    
}
