package com.km.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSales {

    private String orderNo;
    private int bizDate;
    private int status;
    private String creator;
    private String productCode;
    private String productName;
    private Long quantity;
    private String unit;

    @Override
    public String toString() {
        return "SalesList{" +
                "orderNo='" + orderNo + '\'' +
                ", bizDate=" + bizDate +
                ", status=" + status +
                ", creator='" + creator + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
