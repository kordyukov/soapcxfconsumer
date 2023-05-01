package com.cfxconsume;

import com.cfxconsume.entity.Customer;
import com.cfxconsume.service.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceTest extends AbstractServiceTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void shouldSave() {
        var response = customerService
                .save(Customer.builder()
                        .customerName("test")
                        .individualDiscount2(1D)
                        .individualDiscount2(1D).build());
    }
}
