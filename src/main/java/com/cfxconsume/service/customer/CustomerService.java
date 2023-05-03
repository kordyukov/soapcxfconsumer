package com.cfxconsume.service.customer;

import com.cfxconsume.model.dto.ChangeDiscountByCustomerDto;
import com.cfxconsume.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer ChangeDiscountByCustomer(ChangeDiscountByCustomerDto changeDiscountByCustomerDto);
}
