package com.km.assignment.dataseed;

import com.github.javafaker.Faker;
import com.km.assignment.entity.User;
import com.km.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.UUID;

@Component
public class UserDataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (userRepository.count() == 0) {
            Faker faker = new Faker();

            for (int i = 0; i < 3; i++) {
                userRepository.insert(new User(
                        UUID.randomUUID().toString().replace("-", ""),
                        "user_" + (i+1),
                        faker.name().firstName(),
                        1,
                        faker.howIMetYourMother().catchPhrase(),
                        0,
                        "programmer",
                        BigInteger.valueOf(System.currentTimeMillis())
                ));
            }
            System.out.println("seed users");
        }
    }
}
