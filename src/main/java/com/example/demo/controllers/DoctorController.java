package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Doctor;
import com.example.demo.domain.User;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;
import com.example.demo.helpers.ExecutionStatus;
import com.example.demo.helpers.UpdatedDoc;
import com.example.demo.helpers.User_Json;
import com.example.demo.services.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/doc/*")
public class DoctorController
{
    private DoctorService docService;
    
    final static Logger logger = LoggerFactory.getLogger(UserAccountController.class);

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
    
    //TODO doc login impl
    @PostMapping(value = "/login", produces = "application/json")
    public ExecutionStatus processDoctorLogin(@RequestBody User reqUser)
    {
        Doctor doc = null;
        try
        {
            doc = docService.isValidDoctor(reqUser.getEmail(), reqUser.getPassword());
        }
        catch(UnmatchingUserCredentialsException e)
        {
            logger.debug(e.getMessage(), e);
        }
        
        if(doc == null)
        {
            System.out.println("Doc Login fehlgeschlagen. Benutzername oder Passwort inkorrekt");
            return new ExecutionStatus("FAILURE", "Username or password is incorrect. Please try again!");
        }
        
        System.out.println("Login von Doktor: " + doc.getFirstName() + " erfolgreich.");
        return new ExecutionStatus("DOCTOR_LOGIN_SUCCESSFUL", "Login Successful!", new User_Json(doc));
    }

    @PostMapping(value = "/changeFirstName", produces = "application/json")
    public Doctor changeFirstName(@RequestBody UpdatedDoc doc)
    {
        Doctor doctor = docService.changeFirstName(doc.getDoc(), doc.getFirstName());
        return doctor;
    }
    
    @PostMapping(value = "/delete", produces = "application/json")
    public void deleteDoctor(@RequestBody Doctor doctor)
    {
       docService.deleteDoctor(doctor);
    }
}
