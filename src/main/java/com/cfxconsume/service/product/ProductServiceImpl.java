package com.cfxconsume.service.product;

import com.cfxconsume.entity.Product;
import com.cfxconsume.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }
}
