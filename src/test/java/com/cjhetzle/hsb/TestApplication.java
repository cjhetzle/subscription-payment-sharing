package com.cjhetzle.hsb;

import org.springframework.boot.SpringApplication;

public class TestApplication {

    /** 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.from(Application::main).with(ContainersConfig.class)
                .run(args);
    }
}
