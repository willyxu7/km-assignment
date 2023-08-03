package com.km.assignment.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatusTest {

    @Test
    void testGetEnumValue() {
        Status paid = Status.PAID;

        assertEquals(2, paid.getStatusInt());
    }
}