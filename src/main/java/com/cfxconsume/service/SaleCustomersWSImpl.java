package com.cfxconsume.service;

import com.cfxconsume.entity.Product;
import com.cfxconsume.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class SaleCustomersWSImpl implements SaleCustomersWS {
    private final ProductService productService;

    @Override
    public String createMessage(String name) {
        return "Hello " + name;
    }

    @Override
    public Collection<Product> findAll() {
        return productService.findAll();
    }
}
