package com.km.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.km.assignment.model.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testInsetSuccess() throws Exception {
        CreateUserRequest userRequest = new CreateUserRequest(
                "124",
                "user_01",
                "xiaowilz",
                1,
                "Empty",
                0,
                "admin",
                BigInteger.valueOf(12312)
        );

        String userRequestJson = objectMapper.writeValueAsString(userRequest);

        mockMvc.perform(
                post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRequestJson)
        ).andExpectAll(
                status().isOk()
        );
    }
}