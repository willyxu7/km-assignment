package com.km.assignment.entity;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    private String id;
    private String orderNo;
    private Integer seq;
    private String itemId;
    private BigInteger price;
    private Long quantity;
    private String unit;
    private String remark;

}
