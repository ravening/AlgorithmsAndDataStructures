package com.rakeshv;

import java.util.HashMap;
import java.util.Map;

public class StrategyPattern {
    public static void main(String[] args) {
        Map<String, Payment> map = new HashMap<>();
        map.put("random", Payment.random());
        map.put("another", Payment.another());
        map.put("onemore", Payment.onemore());

        double payment = map.get("onemore").pay(10, 2, 3, 4, 5);
        System.out.println(payment);
    }

}

interface Payment {
    double pay(double amount, double a, double b, double c, double d);

    static Payment random() {
        return (amount, a, b, c, d) -> amount;
    }

    static Payment another() {
        return ((amount, a, b, c, d) -> amount + a +b);
    }

    static Payment onemore() {
        return ((amount, a, b, c, d) -> amount * a * b * c * d);
    }
}
