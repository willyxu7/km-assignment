package com.km.assignment.service.impl;

import com.km.assignment.model.OrderSalesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderSalesServiceImplTest {

    @Autowired
    private OrderSalesServiceImpl orderSalesService;

    @Test
    void getOrderSalesSortedByQuantity() {
        List<OrderSalesResponse> orderSalesSortedByQuantity = orderSalesService.getOrderSalesSortedByQuantity();
        assertNotNull(orderSalesSortedByQuantity);

    }
}