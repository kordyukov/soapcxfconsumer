package com.cfxconsume.service;

import com.cfxconsume.entity.Product;
import com.cfxconsume.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleCustomersWSImpl implements SaleCustomersWS {
    private final ProductService productService;

    @Override
    public String createMessage(String name) {
        return "Hello " + name;
    }

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productService.saveProduct(product);
    }
}
