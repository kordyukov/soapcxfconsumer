package com.cfxconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cfxconsume.entity")
public class SoapcxfconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapcxfconsumerApplication.class, args);
    }

}
