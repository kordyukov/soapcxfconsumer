package com.cfxconsume.soapcxfconsumer.service;

import org.springframework.stereotype.Component;

@Component
public class SaleCustomersWSImpl implements SaleCustomersWS {
    @Override
    public String createMessage(String name) {
        return "Hello " + name;
    }
}
