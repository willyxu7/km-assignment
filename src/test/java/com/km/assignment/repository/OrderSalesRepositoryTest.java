package com.km.assignment.repository;

import com.km.assignment.entity.OrderSales;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class OrderSalesRepositoryTest {

    @Autowired
    private OrderSalesRepository salesRepository;

    @Test
    void testGetSales() {
        List<OrderSales> sales = salesRepository.getOrderSalesSortedByQuantity();
        sales.forEach(sale -> {
            System.out.println(sale.toString());
        });
    }
}