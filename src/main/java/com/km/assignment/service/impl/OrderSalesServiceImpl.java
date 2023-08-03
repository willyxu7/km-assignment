package com.km.assignment.service.impl;

import com.km.assignment.mapper.OrderSalesMapper;
import com.km.assignment.entity.OrderSales;
import com.km.assignment.model.OrderSalesResponse;
import com.km.assignment.repository.OrderSalesRepository;
import com.km.assignment.service.OrderSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderSalesServiceImpl implements OrderSalesService {

    @Autowired
    private OrderSalesRepository orderSalesRepository;

    @Override
    public List<OrderSalesResponse> getOrderSalesSortedByQuantity() {
        List<OrderSales> orderSalesLists = orderSalesRepository.getOrderSalesSortedByQuantity();

        return orderSalesLists.stream()
                .map(OrderSalesMapper::mapOrderSalesToOrderSalesResponse)
                .collect(Collectors.toList());
    }
}
