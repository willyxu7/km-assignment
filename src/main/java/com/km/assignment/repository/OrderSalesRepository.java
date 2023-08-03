package com.km.assignment.repository;

import com.km.assignment.entity.OrderSales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderSalesRepository {

//    @Select("SELECT order_detail.order_no as orderNo, order_detail.quantity as quantity, product.code as productCode, product.name as productName"
//            + " FROM order_detail LEFT JOIN product ON order_detail.item_id = product.ID ORDER BY quantity DESC")
//    public List<Sales> getSalesList();

    @Select("SELECT orders.order_no as orderNo, orders.biz_date as bizDate, orders.status as status, orders.creator as creator, product.code as productCode, product.name as productName, order_detail.quantity as quantity, order_detail.unit as unit"
            + " FROM orders"
            + " LEFT JOIN order_detail ON orders.order_no = order_detail.order_no"
            + " LEFT JOIN product ON order_detail.item_id = product.ID ORDER BY quantity DESC")
    public List<OrderSales> getOrderSalesSortedByQuantity();

}
