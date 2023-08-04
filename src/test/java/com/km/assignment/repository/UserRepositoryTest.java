package com.km.assignment.repository;

import com.km.assignment.entity.User;
import com.km.assignment.exception.UserNotFoundException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SqlSession session;

    @Test
    void testInsertSuccess() {
        User user = new User();
        user.setId("1");
        user.setCode("user_01");
        user.setName("Xiaowilz");
        user.setStatus(1);
        user.setRemark("");
        user.setDeleted(0);
        user.setCreator("admin");
        user.setCreatedTime(BigInteger.valueOf(123));

        Integer insert = userRepository.insert(user);
        assertNotNull(insert);
    }

    @Test
    void testCount() {
        Integer count = userRepository.count();
        assertEquals(4, count);
    }

    @Test
    void testGetOne() throws IOException {
        User user = userRepository.getOne();
        assertEquals("Natacha", user.getName());
    }

    @Test
    void testFindById() throws UserNotFoundException {
        User user = userRepository.findById("bd09388ce44540c8b0b273a2f47b71f6")
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        assertEquals("Bonny", user.getName());
    }
}