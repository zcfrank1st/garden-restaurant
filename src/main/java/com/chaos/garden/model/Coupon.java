package com.chaos.garden.model;

import lombok.Data;

/**
 * Created by zcfrank1st on 6/17/16.
 */
@Data
public class Coupon {
    private String code;
    private int value;
    private String expiredTime;
}
