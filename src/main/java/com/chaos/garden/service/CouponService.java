package com.chaos.garden.service;

import com.chaos.garden.Utils.CouponUtils;
import com.chaos.garden.model.Coupon;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zcfrank1st on 6/17/16.
 */
@Service
public class CouponService {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private CouponUtils couponUtils;

    public Set<String> generateCoupons(int num, int value, String endtime) {
        Set<String> coupons = couponUtils.getCoupons(num);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd"); // yyyy-MM-dd 00:00:00 expired
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

    public List<Coupon> getAllValidCoupons() {
        List<Coupon> coupons = new ArrayList<>();
        cacheService.getAllValidCoupons().stream().filter(e -> cacheService.getRemainingSeconds(e) > 0).forEach(e -> {
            Coupon coupon = new Coupon();
            coupon.setExpiredTime(new DateTime().plusSeconds((int)cacheService.getRemainingSeconds(e)).toString("yyyy-MM-dd"));
            coupon.setCode(e);
            coupon.setValue(cacheService.getCouponValue(e));
            coupons.add(coupon);
        });

        return coupons;
    }
}
