package com.cfxconsume.service.product;

import com.cfxconsume.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product saveProduct(Product product);
}
