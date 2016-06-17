package com.chaos.garden.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Created by zcfrank1st on 6/16/16.
 */
@Service
@Slf4j
public class CacheService {
    private static final int COUPON = 1;
    @Autowired
    private JedisPool jedisPool;


    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    public void setOrUpdateCache(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String getCacheValue(String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void registerCouponsWithExpires(String key, String value, int second) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(COUPON);
            jedis.set(key, value);

            if (second > 0) {
                jedis.expire(key, second);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public boolean checkCoupon (String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(COUPON);
            return jedis.exists(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public int getCouponValue (String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(COUPON);
            return Integer.parseInt(jedis.get(key));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void deleteCoupon (String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(COUPON);
            jedis.del(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public long getRemainingSeconds (String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(COUPON);
            return jedis.ttl(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Set<String> getAllValidCoupons () {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.select(COUPON);
            return jedis.keys("*");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
