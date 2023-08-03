package com.km.assignment.entity;

public enum Status {
    PENDING_PAYMENT(1),
    PAID(2),
    PAYMENT_FAILED(3),
    REFUND(4);

    private Integer statusInt;

    public Integer getStatusInt() {
        return this.statusInt;
    }

    private Status(Integer statusInt) {
        this.statusInt = statusInt;
    }
}
