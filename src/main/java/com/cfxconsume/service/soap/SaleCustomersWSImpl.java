package com.cfxconsume.service.soap;

import com.cfxconsume.entity.Customer;
import com.cfxconsume.entity.Position;
import com.cfxconsume.entity.Product;
import com.cfxconsume.service.customer.CustomerService;
import com.cfxconsume.service.position.PositionService;
import com.cfxconsume.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service("saleWs")
@RequiredArgsConstructor
public class SaleCustomersWSImpl implements SaleCustomersWS {
    @Inject
    private final ProductService productService;
    @Inject
    private final CustomerService customerService;
    @Inject
    private final PositionService positionService;

    @Override
    public String createMessage(String name) {
        return "Hello " + name;
    }

    @Override
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @Override
    public Product saveProduct(Product product) {
        return productService.saveProduct(product);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerService.findAllCustomers();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionService.findAllPosition();
    }
}
