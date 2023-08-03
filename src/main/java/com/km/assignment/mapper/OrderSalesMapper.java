package com.km.assignment.mapper;

import com.km.assignment.model.OrderSalesList;
import com.km.assignment.model.OrderSalesResponse;
import com.km.assignment.model.UpdatePaymentToPaidResponse;

public class OrderSalesMapper {

    public static OrderSalesResponse mapOrderSalesToOrderSalesResponse(OrderSalesList orderSalesList) {
        return OrderSalesResponse.builder()
                .orderNo(orderSalesList.getOrderNo())
                .bizDate(orderSalesList.getBizDate())
                .status(orderSalesList.getStatus())
                .creator(orderSalesList.getCreator())
                .productCode(orderSalesList.getProductCode())
                .productName(orderSalesList.getProductName())
                .quantity(orderSalesList.getQuantity())
                .unit(orderSalesList.getUnit())
                .build();
    }

}
