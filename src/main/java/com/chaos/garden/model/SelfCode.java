package com.chaos.garden.model;

/**
 * Created by zcfrank1st on 6/13/16.
 */
public enum SelfCode {
    SERVICE_ERROR(100);

    private int code;
    SelfCode(int value) {
        code = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
