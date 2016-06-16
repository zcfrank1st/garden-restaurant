package com.chaos.garden;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by zcfrank1st on 6/13/16.
 */
@Configuration
@ImportResource("classpath:applicationContext.xml")
@EnableAsync
public class AppConfig {
    @Bean
    public Config conf() {
        return ConfigFactory.load();
    }
}
