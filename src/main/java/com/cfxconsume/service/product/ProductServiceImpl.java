package com.cfxconsume.service.product;

import com.cfxconsume.entity.Product;
import com.cfxconsume.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
