package com.example.demo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.domain.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.UserDAO;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class UserServiceTest
{

    @Mock
    private UserDAO userDAO;
    
    private UserService userService;
    
    @BeforeEach
    public void setUp() throws Exception
    {
        this.userService = new UserServiceImpl(this.userDAO);
    }

    @AfterEach
    public void tearDown() throws Exception
    {
    }


     @Test
     @DisplayName("Throws exception if user with given email does not exist")
     void Should_throwException_When_UserDoesNotExist()
     {
         String email = "foo@bar.com";
         Mockito.when(this.userDAO.findByEmail(email)).thenReturn(new ArrayList<User>());
         assertThatThrownBy(() -> this.userService.doesUserExist(email)).isInstanceOf(UserNotFoundException.class).hasMessage("User does not exist in the database.");
     }
    
     @Disabled
     @Test
     @DisplayName("Throws exception if user with given email & password is not found in the database")
     void Should_throwException_When_UnmatchingUserCredentialsFound()
     {
     fail("Not yet implemented");
     }
}
