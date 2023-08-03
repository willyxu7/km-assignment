package com.km.assignment.entity;

import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private int bizDate;
    private String orderNo;
    private Integer status;
    private String remark;
    private String creator;
    private Long createdTime;


}
