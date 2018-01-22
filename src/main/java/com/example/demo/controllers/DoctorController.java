package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Doctor;
import com.example.demo.helpers.UsersInfo;
import com.example.demo.services.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/doc/*")
public class DoctorController
{
    private DoctorService docService;
    
    @Autowired
    public DoctorController(DoctorService docService)
    {
        this.docService = docService;
    }
    
    
    @GetMapping
    public Doctor[] getAllDoctors()
    {
        Doctor[] docs = docService.findAll();
        System.out.println(docs[0].getFirstName());
        return docs;
    }
}
