package com.km.assignment.repository;

import com.km.assignment.entity.Product;
import com.km.assignment.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {

    //    @Insert("INSERT INTO user(ID, code, name, status, remark, deleted, creator, created_time)" +
//    " VALUES (#{id}, #{code}, #{name}, #{status}, #{remark}, #{deleted}, #{creator}, #{createdTime})")
    public Integer insert(User user);

    //    @Select("SELECT * FROM user WHERE ID = #{id}")
    public Optional<User> findById(@Param("id") String id);

    //    @Select("SELECT * FROM user LIMIT 1")
    public User getOne();

    //    @Select("SELECT COUNT(*) FROM user")
    public Integer count();

}
