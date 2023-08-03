package com.km.assignment.repository;

import com.km.assignment.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductRepository {

    @Insert("INSERT INTO product(ID, code, name, price, unit, remark, deleted, creator, created_time)" +
            " VALUES (#{id}, #{code}, #{name}, #{price}, #{unit}, #{remark}, #{deleted}, #{creator}, #{createdTime})")
    public Integer insert(Product product);

    @Select("SELECT * FROM product LIMIT 1")
    public Product getOne();

    @Select("SELECT * FROM product LIMIT #{limit}")
    public List<Product> getLimit(int limit);

    @Select("SELECT * FROM product where ID = #{id}")
    public Optional<Product> findById(@Param("id") String id);

    @Select("SELECT COUNT(*) FROM product")
    public Integer count();

}
