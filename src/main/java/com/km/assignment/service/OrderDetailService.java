package com.km.assignment.service;

import com.km.assignment.entity.OrderDetail;

public interface OrderDetailService {

    public Integer insert(OrderDetail orderDetail);

    public OrderDetail findByOrderNo(String orderNo);

}
