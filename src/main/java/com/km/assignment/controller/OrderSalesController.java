package com.km.assignment.controller;

import com.km.assignment.model.OrderSalesResponse;
import com.km.assignment.service.OrderSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderSalesController {

    @Autowired
    private OrderSalesService orderSalesService;

    @GetMapping("/order/sales")
    public ResponseEntity<List<OrderSalesResponse>> getOrderSalesSortedByQuantity() {
        return ResponseEntity.ok(orderSalesService.getOrderSalesSortedByQuantity());
    }

}
