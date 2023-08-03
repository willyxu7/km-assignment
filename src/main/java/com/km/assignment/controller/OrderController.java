package com.km.assignment.controller;

import com.km.assignment.exception.FailedUpdatePaymentException;
import com.km.assignment.exception.FailedUpdateQuantityException;
import com.km.assignment.exception.ProductNotFoundException;
import com.km.assignment.exception.UserNotFoundException;
import com.km.assignment.model.*;
import com.km.assignment.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/order")
    public ResponseEntity<CreateOrderResponse> insert(@Valid @RequestBody CreateOrderRequest createOrderRequest) throws UserNotFoundException, ProductNotFoundException {
        CreateOrderResponse createOrderResponse = orderService.insert(createOrderRequest);
        return ResponseEntity.ok(createOrderResponse);
    }

    @PostMapping(path = "/order/paid")
    public ResponseEntity<UpdatePaymentToPaidResponse> updatePaymentToPaid(@RequestBody UpdatePaymentToPaidRequest updatePaymentToPaidRequest) throws FailedUpdatePaymentException {
        UpdatePaymentToPaidResponse updatePaymentToPaidResponse = orderService.updatePaymentToPaid(updatePaymentToPaidRequest.getOrderId());
        return ResponseEntity.ok(updatePaymentToPaidResponse);
    }

    @PatchMapping(path = "/order/{orderId}/quantity")
    public ResponseEntity<UpdateOrderQuantityResponse> updateOrderQuantity(
            @PathVariable String orderId,
            @Valid @RequestBody UpdateOrderQuantityRequest updateOrderQuantityRequest
    ) throws FailedUpdateQuantityException {
        UpdateOrderQuantityResponse updateOrderQuantityResponse = orderService.updateOrderQuantity(orderId, updateOrderQuantityRequest);
        return ResponseEntity.ok(updateOrderQuantityResponse);
    }

}
