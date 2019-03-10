package com.smarthouse.user.controller;

import com.smarthouse.commonutil.exceptions.ResourceNotFound;
import com.smarthouse.user.entity.User;
import com.smarthouse.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Supplier;

import static com.smarthouse.commonutil.exceptions.ResourceNotFound.getNoResourceMessage;

@RestController
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(final UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> userOptional = userService.getById(id);
        return ResponseEntity.ok(userOptional.orElseThrow((Supplier<RuntimeException>) () ->
                new ResourceNotFound(getNoResourceMessage("User", id))
        ));
    }
}
