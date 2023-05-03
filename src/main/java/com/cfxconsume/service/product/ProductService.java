package com.cfxconsume.service.product;

import com.cfxconsume.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product saveProduct(Product product);
}
