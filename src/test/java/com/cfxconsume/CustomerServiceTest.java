package com.cfxconsume;

import com.cfxconsume.model.entity.Customer;
import com.cfxconsume.repository.CustomerRepository;
import com.cfxconsume.service.customer.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CustomerServiceTest implements AbstractServiceTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    public void clean() {
       customerRepository.deleteAll();
    }

    @Test
    public void shouldSave() {
        var response = customerService
                .saveCustomer(Customer.builder()
                        .id(UUID.randomUUID())
                        .customerName("ewer")
                        .individualDiscountOne(1D)
                        .individualDiscountTwo(1D).build());
    }
}
