package com.smarthouse.user.controller;

import com.smarthouse.commonutil.entities.Device;
import com.smarthouse.user.service.DeviceService;
import com.smarthouse.user.service.UserDeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


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
    public ResponseEntity<Set<Device>> getUserById(@PathVariable("id") Long userId) {
        Set<Long> ids = new HashSet<>(userDeviceService.getUserDevicesIds(userId));
        return ResponseEntity.ok(deviceService.getDevices(ids));
    }

}
