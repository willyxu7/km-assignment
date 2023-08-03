package com.km.assignment.dataseed;

import com.github.javafaker.Faker;
import com.km.assignment.entity.Product;
import com.km.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

@Component
public class ProductDataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if(productRepository.count() == 0) {
            Faker faker = new Faker();
            Random random = new Random();

            List<String> units = Arrays.asList("pcs", "kg", "g");

            for (int i = 0; i < 30; i++) {
                String unit = units.get(random.nextInt(units.size()));

                Product product = new Product();
                product.setId(UUID.randomUUID().toString().replace("-", ""));
                product.setCode("product_" + (i+1));
                product.setName(String.valueOf(faker.food().dish()));
                product.setPrice(Long.valueOf(faker.number().numberBetween(1, 1_000)));
                product.setUnit(unit);
                product.setRemark(faker.howIMetYourMother().catchPhrase());
                product.setDeleted(0);
                product.setCreator("programmer");
                product.setCreatedTime(BigInteger.valueOf(System.currentTimeMillis()));
                productRepository.insert(product);
            }
            System.out.println("seed products");
        }
    }
}
