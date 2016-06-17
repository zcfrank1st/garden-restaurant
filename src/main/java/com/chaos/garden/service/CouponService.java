package com.chaos.garden.service;

import com.chaos.garden.Utils.Coupon;
import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by zcfrank1st on 6/17/16.
 */
@Service
public class CouponService {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private Coupon coupon;

    public Set<String> generateCoupons(int num, int value, String endtime) {
        Set<String> coupons = coupon.getCoupons(num);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");
        DateTime end = formatter.parseDateTime(endtime);
        DateTime now = new DateTime();

        int duringSeconds = Seconds.secondsBetween(now, end).getSeconds();

        coupons.forEach(e -> cacheService.registerCouponsWithExpires(e, value + "", duringSeconds));
        return coupons;
    }

    public boolean validateCoupon (String key) {
        return cacheService.checkCoupon(key);
    }

    public void deleteCoupon (String key) {
        cacheService.deleteCoupon(key);
    }

    public int getCouponValue(String key) {
        return cacheService.getCouponValue(key);
    }
}
