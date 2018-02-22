package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return docs;
    }
    
    @PostMapping(value = "/bySpeciality", produces = "application/json")
    public Doctor[] getDoctorsBySpeciality(ModelMap model, @RequestBody String speciality)
    {
        Doctor[] docs = docService.getBySpeciality(speciality);
        return docs;
    }
}
