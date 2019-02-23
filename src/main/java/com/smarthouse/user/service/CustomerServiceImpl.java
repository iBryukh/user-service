package com.smarthouse.user.service;

import com.smarthouse.user.entity.Customer;
import com.smarthouse.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<Customer, Long> {
    @Autowired
    public CustomerServiceImpl(final CustomerRepository repository) {
        super(repository);
    }
}
