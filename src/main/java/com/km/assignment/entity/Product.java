package com.km.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String code;
    private String name;
    private Long price;
    private String unit;
    private String remark;
    private Integer deleted;
    private String creator;
    private BigInteger createdTime;

}
