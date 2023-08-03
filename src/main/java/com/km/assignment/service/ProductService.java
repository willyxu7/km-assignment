package com.km.assignment.service;

import com.km.assignment.entity.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Integer insert(Product product);

    public Product getOne();

    public List<Product> getLimit(int limit);

    public Optional<Product> findById(String id);

    public Integer count();

}
