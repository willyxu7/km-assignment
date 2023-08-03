package com.km.assignment.service.impl;

import com.km.assignment.entity.OrderDetail;
import com.km.assignment.repository.OrderDetailRepository;
import com.km.assignment.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Integer insert(OrderDetail orderDetail) {
        return orderDetailRepository.insert(orderDetail);
    }

    @Override
    public OrderDetail findByOrderNo(String orderNo) {
        return orderDetailRepository.findByOrderNo(orderNo);
    }
}
