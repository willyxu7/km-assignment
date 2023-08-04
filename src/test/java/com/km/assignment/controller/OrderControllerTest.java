package com.km.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.km.assignment.entity.Order;
import com.km.assignment.entity.Product;
import com.km.assignment.entity.User;
import com.km.assignment.model.CreateOrderRequest;
import com.km.assignment.model.UpdateOrderQuantityRequest;
import com.km.assignment.model.UpdatePaymentToPaidRequest;
import com.km.assignment.repository.OrderRepository;
import com.km.assignment.repository.ProductRepository;
import com.km.assignment.repository.UserRepository;
import com.km.assignment.service.OrderService;
import com.km.assignment.service.ProductService;
import com.km.assignment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

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
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    private Random random;

    @BeforeEach
    void setUp() {
        random = new Random();
    }

    @Test
    void testInsertOrderSuccess() throws Exception {
        List<Product> products = productService.getLimit(5);
        products.forEach(product -> {
            CreateOrderRequest createOrderRequest = new CreateOrderRequest();
            createOrderRequest.setUserId(userService.getOne().getId());
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

    /***
     * Don't forget to change user id with existing user id in database
     * @throws InterruptedException
     */
    @Test
    void testInsertOrderSuccessMultiThread() throws InterruptedException {
        List<Product> products = productService.getLimit(5);
        Optional<User> user1 = userService.findById("001571ba446a4fd89a2316ed5ae9da29");
        Optional<User> user2 = userService.findById("12b054b9c46340058c1e39ae8bcf51d6");
        Optional<User> user3 = userService.findById("3fbefcea88bc442980e654cd61fde2ff");

        new Thread(() -> {
            System.out.println("Thread is running");
        }).start();

        new Thread(() -> {
            products.forEach(product -> {
                CreateOrderRequest createOrderRequest = new CreateOrderRequest();
                createOrderRequest.setUserId(user1.get().getId());
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
        }).start();

        new Thread(() -> {
            products.forEach(product -> {
                CreateOrderRequest createOrderRequest = new CreateOrderRequest();
                createOrderRequest.setUserId(user2.get().getId());
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
        }).start();

        new Thread(() -> {
            products.forEach(product -> {
                CreateOrderRequest createOrderRequest = new CreateOrderRequest();
                createOrderRequest.setUserId(user3.get().getId());
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
        }).start();

        Thread.sleep(10 * 1000);
    }

    @Test
    void testUpdatePaymentToPaid() throws Exception {
        Order order = orderService.findOne();

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
                        patch("/order/" + orderId + "/quantity")
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
                        patch("/order/" + orderId + "/quantity")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(updateOrderQuantityJson)
                ).andExpectAll(status().isBadRequest());
    }
}