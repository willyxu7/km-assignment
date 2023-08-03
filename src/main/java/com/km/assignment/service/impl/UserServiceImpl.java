package com.km.assignment.service.impl;

import com.km.assignment.entity.User;
import com.km.assignment.mapper.UserMapper;
import com.km.assignment.model.CreateUserRequest;
import com.km.assignment.repository.UserRepository;
import com.km.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    public int insert(CreateUserRequest userRequest) {
        return userRepository.insert(UserMapper.mapUserRequestToUser(userRequest));
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User getOne() {
        return userRepository.getOne();
    }

    @Override
    public Integer count() {
        return userRepository.count();
    }


}
