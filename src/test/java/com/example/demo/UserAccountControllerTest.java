package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.controllers.UserAccountController;
import com.example.demo.domain.User;
import com.example.demo.helpers.ExecutionStatus;
import com.example.demo.services.DoctorService;
import com.example.demo.services.UserService;
import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@Tag("Controller")
@SpringBootTest
public class UserAccountControllerTest
{
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    
    @MockBean
    private DoctorService docService;
    

    @BeforeEach
    public void setUp() throws Exception
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserAccountController(this.userService, this.docService)).build();
    }
    
    @AfterEach
    public void tearDown() throws Exception
    {
        
    }
    
    @Test
    @DisplayName("Should return error message for when user not existing in database tries to login")
    public void shouldReturnErrorMessageForUnmatchtingUser() throws Exception
    {
        User user = new User();
        user.setEmail("foo@bar.com");
        user.setPassword("foobar");
        
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);
        
        // Pre-program the behavior of Mock; When isValidUser method is invoked, return null object
        Mockito.when(this.userService.isValidUser("foo@bar.com", "foobar")).thenReturn(null);
        
        // Invoke the controller method
        MvcResult result = this.mockMvc.perform(post("/account/login").contentType(MediaType.APPLICATION_JSON).content(jsonUser)).andExpect(status().isOk()).andReturn();
        
        // Verify the program behavior; Assert the response object
        MockHttpServletResponse response = result.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        ExecutionStatus responseObj = mapper.readValue(response.getContentAsString(), ExecutionStatus.class);
        assertTrue(responseObj.getCode().equals("FAILURE"));
        assertTrue(responseObj.getMessage().equals("Username or password is incorrect. Please try again!"));
    }
}
