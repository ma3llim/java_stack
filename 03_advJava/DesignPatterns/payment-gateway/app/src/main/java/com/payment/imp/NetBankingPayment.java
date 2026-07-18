package com.payment.imp;

import com.payment.strategy.PaymentStrategy;

public class NetBankingPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + "[" + amount+ "] via Net Banking");
    }
}
