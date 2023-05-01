package com.cfxconsume.service.customer;

import com.cfxconsume.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Customer save(Customer customer);
}
