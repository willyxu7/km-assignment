package com.km.assignment.repository;

import com.km.assignment.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    void testInsertSuccess() {

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId("1");
        orderDetail.setOrderNo("Order202308030002");
        orderDetail.setSeq(1);
        orderDetail.setItemId("1");
        orderDetail.setPrice(BigInteger.valueOf(10000000));
        orderDetail.setQuantity(10L);
        orderDetail.setUnit("pcs");
        orderDetail.setRemark("");

        Integer inserted = orderDetailRepository.insert(orderDetail);

        assertEquals(1, inserted);
    }

    @Test
    void testFindByOrderNo() {
        OrderDetail orderDetail = orderDetailRepository.findByOrderNo("Order202308030002");
        assertNotNull(orderDetail);
    }
}