package com.halo.logging;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Halo
 * @date Created in 2021/05/20 4:50 PM
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(Main.class);
        log.info("start...");
        log.warn("end.");
    }
}