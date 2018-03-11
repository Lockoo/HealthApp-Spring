package com.example.demo.controllers;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Doctor;
//import com.example.demo.configuration.CustomAuthenticationProvider;
import com.example.demo.domain.User;
import com.example.demo.exceptions.UnmatchingUserCredentialsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.helpers.ExecutionStatus;
import com.example.demo.helpers.User_Json;
import com.example.demo.helpers.UsersInfo;
import com.example.demo.services.DoctorService;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/account/*")
public class UserAccountController
{
    final static Logger logger = LoggerFactory.getLogger(UserAccountController.class);

    private UserService userService;

    private DoctorService doctorService;

    @Autowired
    public UserAccountController(UserService userService, DoctorService doctorService)
    {
        this.userService = userService;
        this.doctorService = doctorService;
    }
    

    @GetMapping(value = "/token")
    public Map<String, String> getToken(HttpSession session)
    {
        return Collections.singletonMap("token", session.getId());
    }

    @PostMapping(value = "/signup")
    public ExecutionStatus processSignup(ModelMap model, @RequestBody User_Json reqUser)
    {
        if (reqUser.getRole() == 0)
        {
            User user = null;
            try
            {
                user = userService.doesUserExist(reqUser.getEmail());
            }
            catch (UserNotFoundException e)
            {
            }
            if (user != null)
            {
                return new ExecutionStatus("USER_ACCOUNT_EXISTS", "User account with same email address exists. Please try again!");
            }

            user = new User();
            user.setEmail(reqUser.getEmail());
            user.setPassword(reqUser.getPassword());
            user.setFirstName(reqUser.getFirstName());
            user.setLastName(reqUser.getLastName());
            user.setRole(reqUser.getRole());

            userService.save(user);
            User_Json user_json = new User_Json(user);

            return new ExecutionStatus("USER_ACCOUNT_CREATED", "User account successfully created", user_json);
        }

        else
        {
            if (doctorService.doesDoctorExist(reqUser.getEmail()))
            {
                return new ExecutionStatus("DOCTOR_ACCOUNT_EXISTS", "Doctor Account with this email exists, please try again.");
            }
            else
            {
                Doctor doc = new Doctor();
                doc.setFirstName(reqUser.getFirstName());
                doc.setLastName(reqUser.getLastName());
                doc.setEmail(reqUser.getEmail());
                doc.setPassword(reqUser.getPassword());
                doc.setSpeciality(reqUser.getSpeciality());

                doctorService.saveDoctor(doc);

                return new ExecutionStatus("DOCTOR_ACCOUNT_CREATED", "Doctor account successfully created", new User_Json(doc));
            }
        }
    }
    
    @GetMapping(value = "test")
    public String test()
    {
        return "test";
    }

    // TODO doc login vorlage
    @PostMapping(value = "/login")
    public ExecutionStatus processLogin(ModelMap model, @RequestBody User reqUser)
    {
        User user = null;
        try
        {
            user = userService.isValidUser(reqUser.getEmail(), reqUser.getPassword());
        }
        catch (UnmatchingUserCredentialsException ex)
        {
            logger.debug(ex.getMessage(), ex);
        }
        if (user == null)
        {
            return new ExecutionStatus("FAILURE", "Username or password is incorrect. Please try again!");
        }

        return new ExecutionStatus("USER_LOGIN_SUCCESSFUL", "Login Successful!", new User_Json(user));
    }

    @PostMapping(value = "/user/update")
    public ExecutionStatus updateUser(ModelMap model, @RequestBody User reqUser)
    {
        User user = new User();
        user.setId(reqUser.getId());
        user.setFirstName(reqUser.getFirstName());
        user.setLastName(reqUser.getLastName());
        userService.update(user);
        return new ExecutionStatus("USER_ACCOUNT_UPDATED", "User account successfully updated");
    }

    @PostMapping(value = "/update", produces = "application/json")
    public ModelAndView updateProfile(ModelMap model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("address") String address, @RequestParam("contact_number") String contactNumber)
    {
        return new ModelAndView("update", model);
    }

    @PostMapping(value = "/forgotpassword/process", produces = "application/json")
    public ModelAndView processForgotPassword(ModelMap model, @RequestParam("emailaddress") String email)
    {

        User user = null;
        try
        {
            user = userService.doesUserExist(email);
        }
        catch (UserNotFoundException e)
        {

            e.printStackTrace();
        }
        if (user != null)
        {

        }
        model.addAttribute("message", "An email notification is sent to the registered email address.");
        return new ModelAndView("forgotpassword", model);
    }

    @GetMapping(value = "/count")
    public UsersInfo getUsersInfo(ModelMap model)
    {
        long count = userService.findCount();
        UsersInfo data = new UsersInfo();
        data.setCount(count);
        data.setMessage("findAllCount");
        return data;
    }

}
