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
        orderDetail.setOrderNo("order2023-08-010001");
        orderDetail.setSeq(1);
        orderDetail.setItemId("0206228b395c4250a5b9638bafc87d6b");
        orderDetail.setPrice(BigInteger.valueOf(10000000));
        orderDetail.setQuantity(10L);
        orderDetail.setUnit("pcs");
        orderDetail.setRemark("");

        Integer inserted = orderDetailRepository.insert(orderDetail);

        assertEquals(1, inserted);

    }
}