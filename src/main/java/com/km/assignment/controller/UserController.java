package com.km.assignment.controller;

import com.km.assignment.model.CreateUserRequest;
import com.km.assignment.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(path = "/user")
    public ResponseEntity<Void> insert(@RequestBody CreateUserRequest userRequest) {
        int inserted = userService.insert(userRequest);
        return ResponseEntity.ok().build();
    }

}
