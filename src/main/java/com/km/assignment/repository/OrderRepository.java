package com.km.assignment.repository;

import com.km.assignment.entity.Order;
import com.km.assignment.model.UpdateOrderQuantityRequest;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderRepository {

//    @Insert("INSERT INTO orders(ID, biz_date, order_no, status, remark, creator, created_time)" +
//            " VALUES (#{id}, #{bizDate}, #{orderNo}, #{status}, #{remark}, #{creator}, #{createdTime})")
    public Integer insert(Order order);

//    @Select("SELECT * FROM orders WHERE ID=#{id}")
    public Order findById(String id);

//    @Select("SELECT * FROM orders LIMIT 1")
    public Order getOne();

//    @Update("UPDATE orders set status=2 WHERE ID=#{id} AND status=1")
    public Integer updatePaymentToPaid(String id);

//    @Update("UPDATE orders, order_detail SET order_detail.quantity=#{updateOrderQuantityRequest.quantity} WHERE orders.id=#{id} AND order_detail.order_no = orders.order_no AND orders.status=1")
    public Integer updateOrderQuantity(String id, UpdateOrderQuantityRequest updateOrderQuantityRequest);
}
