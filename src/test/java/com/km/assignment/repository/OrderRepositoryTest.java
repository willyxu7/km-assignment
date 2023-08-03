package com.km.assignment.repository;

import com.km.assignment.entity.Order;
import com.km.assignment.entity.Status;
import com.km.assignment.helper.DateHelper;
import com.km.assignment.helper.OrderHelper;
import com.km.assignment.model.UpdateOrderQuantityRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testInsertSuccess() {
        Order order = Order.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .bizDate(DateHelper.generateDate())
                .status(Status.PENDING_PAYMENT.getStatusInt())
                .orderNo(OrderHelper.generateOrderNumber())
                .remark("")
                .creator("1")
                .createdTime(System.currentTimeMillis())
                .build();

        Integer inserted = orderRepository.insert(order);
        assertEquals(1, inserted);

    }

    @Test
    void testChangePaymentStatusToPaid() {
        Order order = orderRepository.findOne();

        Integer updated = orderRepository.updatePaymentToPaid(order.getId());
        order = orderRepository.findById(order.getId());

        assertEquals(1, updated);
        assertEquals(3, order.getStatus());
    }

    @Test
    void testUpdateOrderQuantity() {
        UpdateOrderQuantityRequest updateOrderQuantityRequest = new UpdateOrderQuantityRequest(30);

        Order order = orderRepository.findOne();

        Integer updateOrderQuantity = orderRepository.updateOrderQuantity(order.getId(), updateOrderQuantityRequest);

        assertEquals(1, updateOrderQuantity);
    }

    @Test
    void testUpdateOrderQuantityFailBecauseStatusPaid() {
        UpdateOrderQuantityRequest updateOrderQuantityRequest = new UpdateOrderQuantityRequest(40);

        Order order = orderRepository.findOne();

        Integer updateOrderQuantity = orderRepository.updateOrderQuantity(order.getId(), updateOrderQuantityRequest);

        assertEquals(0, updateOrderQuantity);
    }
}