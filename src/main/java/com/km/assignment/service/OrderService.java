package com.km.assignment.service;

import com.km.assignment.entity.Order;
import com.km.assignment.exception.FailedUpdatePaymentException;
import com.km.assignment.exception.FailedUpdateQuantityException;
import com.km.assignment.exception.ProductNotFoundException;
import com.km.assignment.exception.UserNotFoundException;
import com.km.assignment.model.*;

public interface OrderService {

    public CreateOrderResponse insert(CreateOrderRequest createOrderRequest) throws UserNotFoundException, ProductNotFoundException;

    public UpdatePaymentToPaidResponse updatePaymentToPaid(String orderId) throws FailedUpdatePaymentException;

    public UpdateOrderQuantityResponse updateOrderQuantity(String orderId, UpdateOrderQuantityRequest updateOrderQuantityRequest) throws FailedUpdateQuantityException;

    public Order findOne();

}
