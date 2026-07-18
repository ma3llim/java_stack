package com.payment.service;

import com.payment.strategy.PaymentStrategy;

public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        paymentStrategy.pay(amount);
    }
}
