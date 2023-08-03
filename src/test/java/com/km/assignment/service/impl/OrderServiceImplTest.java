package com.km.assignment.service.impl;

import com.km.assignment.entity.Product;
import com.km.assignment.exception.ProductNotFoundException;
import com.km.assignment.exception.UserNotFoundException;
import com.km.assignment.model.CreateOrderRequest;
import com.km.assignment.model.CreateOrderResponse;
import com.km.assignment.repository.ProductRepository;
import com.km.assignment.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testUserActive() throws UserNotFoundException, ProductNotFoundException {
        Product product = productRepository.getOne();

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(
                product.getId(),
                "1",
                10L,
                ""
        );

        CreateOrderResponse createOrderResponse = orderService.insert(createOrderRequest);

        assertNotNull(createOrderResponse);
    }

    @Test
    void testUserNotFound() throws UserNotFoundException {
        UserNotFoundException userNotFoundException = assertThrows(UserNotFoundException.class, () -> {
            Product product = productRepository.getOne();

            CreateOrderRequest createOrderRequest = new CreateOrderRequest(
                    product.getId(),
                    "4",
                    10L,
                    ""
            );

            orderService.insert(createOrderRequest);
        });
        assertEquals("user not found", userNotFoundException.getMessage());
    }
}