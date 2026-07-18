package com.payment.imp;

import com.payment.strategy.PaymentStrategy;

public class UpiPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + "[" + amount+ "] via UP");
    }
}
