package com.smarthouse.user.controller;

import com.smarthouse.user.entity.Customer;
import com.smarthouse.user.exception.ResourceNotFound;
import com.smarthouse.user.service.CustomerServiceImpl;
import com.smarthouse.user.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class CustomerController {

    private CustomerServiceImpl customerService;
    private RoleServiceImpl roleService;

    @Autowired
    public CustomerController(final CustomerServiceImpl customerService, final RoleServiceImpl roleService) {
        this.customerService = customerService;
        this.roleService = roleService;
    }

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomerById(@RequestHeader("id") Long id) {
        Optional<Customer> customerOptional = customerService.getById(id);
        return ResponseEntity.ok(
                customerOptional.orElseThrow((Supplier<RuntimeException>) () ->
                        new ResourceNotFound(String.format("User with id %d doesn't exists", id))
                )
        );
    }
}
