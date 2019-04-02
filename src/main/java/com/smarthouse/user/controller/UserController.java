package com.smarthouse.user.controller;

import com.smarthouse.commonutil.exceptions.ResourceNotFound;
import com.smarthouse.user.entity.User;
import com.smarthouse.user.service.DeviceService;
import com.smarthouse.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Supplier;

import static com.smarthouse.commonutil.exceptions.ResourceNotFound.getNoResourceMessage;

@RestController
public class UserController {

    private UserServiceImpl userService;
    private DeviceService deviceService;

    @Autowired
    public UserController(final UserServiceImpl userService, final DeviceService deviceService) {
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        Optional<User> userOptional = userService.getById(id);
        return ResponseEntity.ok(userOptional.orElseThrow((Supplier<RuntimeException>) () ->
                new ResourceNotFound(getNoResourceMessage("User", id))
        ));
    }

    @PostMapping("/user")
    public ResponseEntity<User> putUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

}
