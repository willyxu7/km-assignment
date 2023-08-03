package com.km.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.km.assignment.entity.Order;
import com.km.assignment.entity.Product;
import com.km.assignment.model.CreateOrderRequest;
import com.km.assignment.model.UpdateOrderQuantityRequest;
import com.km.assignment.model.UpdatePaymentToPaidRequest;
import com.km.assignment.repository.OrderRepository;
import com.km.assignment.repository.ProductRepository;
import com.km.assignment.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testInsertOrderSuccess() throws Exception {
        Random random = new Random();
        List<Product> products = productRepository.getLimit(10);
        products.forEach(product -> {
            CreateOrderRequest createOrderRequest = new CreateOrderRequest();
            createOrderRequest.setUserId(userRepository.getOne().getId());
            createOrderRequest.setItemId(product.getId());
            createOrderRequest.setQuantity(random.nextLong(100));

            try {
                String createOrderRequestJson = objectMapper.writeValueAsString(createOrderRequest);
                mockMvc.perform(
                        post("/order")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(createOrderRequestJson)
                ).andExpectAll(
                        status().isOk()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void testUpdatePaymentToPaid() throws Exception {
        Order order = orderRepository.findOne();

        UpdatePaymentToPaidRequest request = new UpdatePaymentToPaidRequest(order.getId());
        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc
                .perform(
                        post("/order/paid")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson)
                ).andExpectAll(status().isOk());
    }

    @Test
    void testUpdateOrderQuantity() throws Exception {
        String orderId = "c103c8348288465da4436d4e647736ee";

        UpdateOrderQuantityRequest updateOrderQuantityRequest = new UpdateOrderQuantityRequest(700);
        String updateOrderQuantityJson = objectMapper.writeValueAsString(updateOrderQuantityRequest);

        mockMvc
                .perform(
                    patch("/order/"+ orderId +"/quantity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateOrderQuantityJson)
                ).andExpectAll(status().isOk());
    }

    @Test
    void testUpdateOrderQuantityButPaid() throws Exception {
        String orderId = "026ce0223d4b454f829529d5bbcc7cea";

        UpdateOrderQuantityRequest updateOrderQuantityRequest = new UpdateOrderQuantityRequest(700);
        String updateOrderQuantityJson = objectMapper.writeValueAsString(updateOrderQuantityRequest);

        mockMvc
                .perform(
                        patch("/order/"+ orderId +"/quantity")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(updateOrderQuantityJson)
                ).andExpectAll(status().isBadRequest());
    }
}