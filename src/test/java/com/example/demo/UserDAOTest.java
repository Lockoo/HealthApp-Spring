package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.repositories.UserDAO;
import com.example.demo.repositories.UserDAOImpl;

@ExtendWith(SpringExtension.class)
@Tag("DAO")
public class UserDAOTest
{
    @MockBean
    private SessionFactory sessionFactory;

    @MockBean
    private Session session;

    private UserDAO userDAO;

    @BeforeEach
    public void setUp() throws Exception
    {
        //
        // Pre-program the mocking behavior resulting into
        // returning a mock instance of Session when getCurrentSession
        // method is invoked on sessionFactory instance
        //
        Mockito.when(this.sessionFactory.getCurrentSession()).thenReturn(this.session);
        this.userDAO = new UserDAOImpl(this.sessionFactory);
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void should_returnEmptyList_forUnmatchingUser()
    {
        Query query = Mockito.mock(Query.class);
        Mockito.when(this.session.getNamedQuery("findByEmail")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(new ArrayList());

        List list = userDAO.findByEmail("foo@bar.com");
        assertAll("Users", () -> assertNotEquals(list, null), () -> assertEquals(list.size(), 0));
    }
}
