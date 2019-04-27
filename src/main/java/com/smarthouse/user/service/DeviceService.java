package com.smarthouse.user.service;

import com.smarthouse.commonutil.entities.Device;
import com.smarthouse.user.clients.DeviceRestTemplateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DeviceService {

    private DeviceRestTemplateClient deviceRestTemplateClient;

    @Autowired
    public DeviceService(final DeviceRestTemplateClient deviceRestTemplateClient) {
        this.deviceRestTemplateClient = deviceRestTemplateClient;
    }

    public Optional<Device> getDevice(final long deviceId) {
        return deviceRestTemplateClient.getDevice(deviceId);
    }

    public Set<Device> getDevices(Set<Long> ids) {
        return deviceRestTemplateClient.getDevicesById(ids);
    }


}
