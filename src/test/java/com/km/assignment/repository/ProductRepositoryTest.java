package com.km.assignment.repository;

import com.km.assignment.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testInsertSuccess() {

        Product product = new Product(
                "1",
                "product_01",
                "Legion 5",
                15_000_000L,
                "50",
                "no comment",
                0,
                "admin",
                BigInteger.valueOf(1)
        );
        Integer inserted = productRepository.insert(product);
        assertEquals(1, inserted);
    }

    @Test
    void testGetOne() {
        Product product = productRepository.getOne();
        assertNotNull(product);
    }

    @Test
    void testGetLimit() {
        List<Product> products = productRepository.getLimit(10);
        assertEquals(10, products.size());
    }

    @Test
    void testCount() {
        Integer count = productRepository.count();
        assertEquals(30, count);
    }

    @Test
    void testFindById() {
        Optional<Product> product = productRepository.findById("1");
        assertEquals("Legion 5", product.get().getName());
    }
}