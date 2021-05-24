package com.halo.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Halo
 * @date Created in 2021/04/15 5:52 PM
 * @description
 */
@SpringBootApplication
@MapperScan("com.halo.database.mapper")
public class DatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}