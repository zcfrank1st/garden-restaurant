package com.chaos.garden.model;

import lombok.Data;

/**
 * Created by zcfrank1st on 6/16/16.
 */
@Data
public class Mail {
    private String toMail;
    private String toPeople;
    private String subject;
    private String content;
}
