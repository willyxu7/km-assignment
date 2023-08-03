package com.km.assignment.service;

import com.km.assignment.entity.User;
import com.km.assignment.model.CreateUserRequest;

import java.util.Optional;

public interface UserService {

    public int insert(CreateUserRequest createUserRequest);

    public Optional<User> findById(String id);

    public User getOne();

    public Integer count();

}
