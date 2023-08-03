package com.km.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sales {

    private String orderNo;
    private int quantity;
    private String productCode;
    private String productName;

    @Override
    public String toString() {
        return "Sales{" +
                "orderNo='" + orderNo + '\'' +
                ", quantity=" + quantity +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
