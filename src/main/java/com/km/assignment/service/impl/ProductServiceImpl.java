package com.km.assignment.service.impl;

import com.km.assignment.entity.Product;
import com.km.assignment.repository.ProductRepository;
import com.km.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Integer insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Product getOne() {
        return productRepository.getOne();
    }

    @Override
    public List<Product> getLimit(int limit) {
        return productRepository.getLimit(limit);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Integer count() {
        return productRepository.count();
    }
}
