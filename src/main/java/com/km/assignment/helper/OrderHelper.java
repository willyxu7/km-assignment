package com.km.assignment.helper;

import com.km.assignment.entity.Status;

public class OrderHelper {

    public static String generateOrderCode() {
        return "Order" + DateHelper.generateDate() + NumberHelper.generateRandomNumber();
    }

    public static String convertStatus(int status) {
        String statusMessage = null;
        switch (status) {
            case 1:
                statusMessage = String.valueOf(Status.PENDING_PAYMENT);
                break;
            case  2:
                statusMessage = String.valueOf(Status.PAID);
                break;
            case  3:
                statusMessage = String.valueOf(Status.PAYMENT_FAILED);
                break;
            case  4:
                statusMessage = String.valueOf(Status.REFUND);
                break;
        }
        return statusMessage;
    }

}
