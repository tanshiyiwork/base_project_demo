package com.github.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppTest {
    private static final Logger log= LoggerFactory.getLogger(AppTest.class);
    public static void main(String[] args) {
        System.out.println("out put log file");
        log.info("logback 成功了");
        log.error("logback 成功了");
        log.debug("logback 成功了");
    }
}
