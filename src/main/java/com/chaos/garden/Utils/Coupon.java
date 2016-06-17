package com.chaos.garden.Utils;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zcfrank1st on 6/17/16.
 */
@Component
public class Coupon {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public Set<String> getCoupons (int number) {
        Set<String> res = new HashSet<String>();
        for(int i = 0; i < number; i++) {
            res.add(generateCoupon());
        }
        return res;
    }

    private String generateCoupon () {
        long num = System.nanoTime();
        if(num < 1)
            throw new IllegalArgumentException("num must be greater than 0.");

        StringBuilder sb = new StringBuilder();
        for (; num > 0; num /= 36) {
            sb.append(ALPHABET.charAt((int) (num % 36)));
        }

        return sb.toString();
    }
}
