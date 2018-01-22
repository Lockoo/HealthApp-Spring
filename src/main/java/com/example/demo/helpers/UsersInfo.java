package com.example.demo.helpers;

import java.util.List;

import com.example.demo.domain.User;

public class UsersInfo
{
    private long count;
    private String message;
    private List<User> users;
    
    public UsersInfo(){}
    
    public UsersInfo(String message, List<User> users)
    {
        this.setUsers(users);
        this.setMessage(message);
    }
    
    public UsersInfo(String message, int count)
    {
        this.setCount(count);
        this.setMessage(message);
    }
    
    public long getCount()
    {
        return count;
    }

    public void setCount(long count)
    {
        this.count = count;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
