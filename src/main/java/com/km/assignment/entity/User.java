package com.km.assignment.entity;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String code;
    private String name;
    private Integer status;
    private String remark;
    private Integer deleted;
    private String creator;
    private BigInteger createdTime;

}
