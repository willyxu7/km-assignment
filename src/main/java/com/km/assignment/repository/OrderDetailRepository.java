package com.km.assignment.repository;

import com.km.assignment.entity.Order;
import com.km.assignment.entity.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDetailRepository {

//    @Insert("INSERT INTO order_detail(ID, order_no, seq, item_id, price, quantity, unit, remark)" +
//            " VALUES (#{id}, #{orderNo}, #{seq}, #{itemId}, #{price}, #{quantity}, #{unit}, #{remark})")
    public Integer insert(OrderDetail orderDetail);

//    @Select("SELECT * FROM order_detail WHERE order_no = #{orderNo}")
    public OrderDetail findByOrderNo(String orderNo);

}
