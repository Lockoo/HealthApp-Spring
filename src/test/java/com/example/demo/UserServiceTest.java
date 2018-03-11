package com.example.demo;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class UserServiceTest
{

    @BeforeEach
    public void setUp() throws Exception
    {
    }

    @AfterEach
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testAbout()
    {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity("localhost:8080/account/test", String.class);
        assert(response.getBody().equals("test"));
    }

    // @Test
    // @DisplayName("Throws exception if user with given email does not exist")
    // void Should_throwException_When_UserDoesNotExist()
    // {
    // fail("Not yet implemented");
    // }
    //
    // @Test
    // @DisplayName("Throws exception if user with given email & password is not
    // found in the database")
    // void Should_throwException_When_UnmatchingUserCredentialsFound()
    // {
    // fail("Not yet implemented");
    // }
}
