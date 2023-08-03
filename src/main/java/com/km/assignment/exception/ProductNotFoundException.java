package com.km.assignment.exception;

import org.apache.ibatis.javassist.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
