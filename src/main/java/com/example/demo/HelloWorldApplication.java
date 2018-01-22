package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldApplication
{
   
    public static void main(String[] args)
    {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
       
    
    @GetMapping("/")
    public String index()
    {
        return "Hello Lucas. How are you?";
    }


}
