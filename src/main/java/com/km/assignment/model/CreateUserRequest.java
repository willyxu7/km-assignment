package com.km.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String id;
    private String code;
    private String name;
    private Integer status;
    private String remark;
    private Integer deleted;
    private String creator;
    private BigInteger createdTime;

}
