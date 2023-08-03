package com.km.assignment.service.impl;

import com.km.assignment.entity.*;
import com.km.assignment.exception.FailedUpdatePaymentException;
import com.km.assignment.exception.ProductNotFoundException;
import com.km.assignment.exception.UserNotFoundException;
import com.km.assignment.helper.DateHelper;
import com.km.assignment.helper.NumberHelper;
import com.km.assignment.helper.OrderHelper;
import com.km.assignment.mapper.OrderMapper;
import com.km.assignment.model.*;
import com.km.assignment.repository.OrderDetailRepository;
import com.km.assignment.repository.OrderRepository;
import com.km.assignment.repository.ProductRepository;
import com.km.assignment.repository.UserRepository;
import com.km.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public CreateOrderResponse insert(CreateOrderRequest createOrderRequest) throws UserNotFoundException, ProductNotFoundException {
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();

        User user = userRepository.findById(createOrderRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        Product product = productRepository.findById(createOrderRequest.getItemId())
                .orElseThrow(() -> new ProductNotFoundException("product not found"));

        if (user.getDeleted() == 0 && user.getStatus() == 1 && product.getDeleted() == 0) {
            Order order = Order.builder()
                    .id(UUID.randomUUID().toString().replace("-", ""))
                    .bizDate(DateHelper.generateDate())
                    .orderNo(OrderHelper.generateOrderCode())
                    .status(Status.PENDING_PAYMENT.getStatusInt())
                    .remark(createOrderRequest.getRemark())
                    .creator(user.getId())
                    .createdTime(System.currentTimeMillis())
                    .build();
            Integer orderInserted = orderRepository.insert(order);

            OrderDetail orderDetail = OrderDetail.builder()
                    .id(UUID.randomUUID().toString().replace("-", ""))
                    .orderNo(order.getOrderNo())
                    .seq(1)
                    .itemId(product.getId())
                    .price(BigInteger.valueOf(product.getPrice()))
                    .quantity(createOrderRequest.getQuantity())
                    .unit("pcs")
                    .remark(order.getRemark())
                    .build();

            Integer orderDetailInserted = orderDetailRepository.insert(orderDetail);

            createOrderResponse.setOrderId(order.getId());
            createOrderResponse.setBizDate(order.getBizDate());
            createOrderResponse.setOrderNo(order.getOrderNo());
            createOrderResponse.setStatus(order.getStatus());
        }

        return createOrderResponse;

    }

    @Override
    public UpdatePaymentToPaidResponse updatePaymentToPaid(String orderId) throws FailedUpdatePaymentException {
        Integer updated = orderRepository.updatePaymentToPaid(orderId);

        if (updated == 0) {
            throw new FailedUpdatePaymentException("failed update payment to paid");
        }

        Order order = orderRepository.findById(orderId);

        return OrderMapper.mapOrderToUpdatePaymentToPaidResponse(order);
    }

    @Override
    public UpdateOrderQuantityResponse updateOrderQuantity(String orderId, UpdateOrderQuantityRequest updateOrderQuantityRequest) {
        Integer updated = orderRepository.updateOrderQuantity(orderId, updateOrderQuantityRequest);

        Order order = orderRepository.findById(orderId);

        return new UpdateOrderQuantityResponse(
                order.getId(),
                orderDetailRepository.findByOrderNo(order.getOrderNo()).getQuantity()
        );
    }

}
