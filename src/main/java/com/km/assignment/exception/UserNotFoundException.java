package com.km.assignment.exception;

import org.apache.ibatis.javassist.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
