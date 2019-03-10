package com.smarthouse.user.controller;

import com.smarthouse.commonutil.exceptions.ResourceNotFound;
import com.smarthouse.user.entity.User;
import com.smarthouse.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(final UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/customer")
    public ResponseEntity<User> getCustomerById(@RequestHeader("id") Long id) {
        Optional<User> customerOptional = userService.getById(id);
        return ResponseEntity.ok(
                customerOptional.orElseThrow((Supplier<RuntimeException>) () ->
                        new ResourceNotFound(String.format("User with id %d doesn't exists", id))
                )
        );
    }
}
