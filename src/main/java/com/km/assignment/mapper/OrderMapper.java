package com.km.assignment.mapper;

import com.km.assignment.entity.Order;
import com.km.assignment.model.UpdatePaymentToPaidResponse;

public class OrderMapper {

    public static UpdatePaymentToPaidResponse mapOrderToUpdatePaymentToPaidResponse(Order order) {
        return UpdatePaymentToPaidResponse.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }

}
