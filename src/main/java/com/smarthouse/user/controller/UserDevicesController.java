package com.smarthouse.user.controller;

import com.smarthouse.commonutil.entities.User;
import com.smarthouse.user.service.DeviceService;
import com.smarthouse.user.service.UserDeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserDevicesController {

    private DeviceService deviceService;
    private UserDeviceServiceImpl userDeviceService;

    @Autowired
    public UserDevicesController(final DeviceService deviceService, final UserDeviceServiceImpl userDeviceService) {
        this.deviceService = deviceService;
        this.userDeviceService = userDeviceService;
    }

    @GetMapping("/isAlive")
    public ResponseEntity<Boolean> isAlive() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/isAliveProtected")
    public ResponseEntity<Boolean> isAliveProtected() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/user/{id}/devices")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        throw new UnsupportedOperationException("Operation unsupported yet");
    }

}
