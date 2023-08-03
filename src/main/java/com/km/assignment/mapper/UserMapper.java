package com.km.assignment.mapper;

import com.km.assignment.entity.User;
import com.km.assignment.model.CreateUserRequest;

public class UserMapper {

    public static User mapUserRequestToUser(CreateUserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .code(userRequest.getCode())
                .name(userRequest.getName())
                .status(userRequest.getStatus())
                .remark(userRequest.getRemark())
                .deleted(userRequest.getDeleted())
                .creator(userRequest.getCreator())
                .createdTime(userRequest.getCreatedTime())
                .build();
    }

}
