package com.halo.autologin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Halo
 * @date Created in 2021/04/16 7:28 PM
 * @description
 */
@SpringBootApplication
@MapperScan("com.halo.autologin.mapper")
public class AutoLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoLoginApplication.class, args);
    }
}
