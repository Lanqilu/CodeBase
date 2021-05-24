package com.halo.slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Halo
 * @date Created in 2021/05/20 5:23 PM
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("start...");
        logger.warn("end.");
    }
}
