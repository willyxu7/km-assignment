package com.km.assignment.repository;

import com.km.assignment.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

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
        assertEquals(1, count);
    }
}