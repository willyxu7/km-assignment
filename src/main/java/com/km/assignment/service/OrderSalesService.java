package com.km.assignment.service;

import com.km.assignment.model.OrderSalesResponse;

import java.util.List;

public interface OrderSalesService {

    public List<OrderSalesResponse> getOrderSalesSortedByQuantity();

}
