package com.payment.imp;

import com.payment.strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + "[" + amount+ "] via Credit Card");
    }
}
