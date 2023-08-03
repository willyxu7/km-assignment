package com.km.assignment.helper;

import java.util.Random;

public class NumberHelper {

    public static String generateRandomNumber() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

}
