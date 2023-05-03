package com.cfxconsume.service.customer;

import com.cfxconsume.converters.CustomerConverter;
import com.cfxconsume.model.dto.ChangeDiscountByCustomerDto;
import com.cfxconsume.model.entity.Customer;
import com.cfxconsume.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer ChangeDiscountByCustomer(ChangeDiscountByCustomerDto changeDiscountByCustomerDto) {
        return saveCustomer(customerConverter.toEntity(changeDiscountByCustomerDto));
    }
}
