package com.smarthouse.user.clients;

import com.smarthouse.commonutil.entities.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class DeviceRestTemplateClient {

    private RestTemplate restTemplate;

    @Autowired
    public DeviceRestTemplateClient(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Device> getDevice(final long deviceId) {
        ResponseEntity<Device> restExchange =
                restTemplate.exchange(
                        "http://device-service/device/{id}",
                        HttpMethod.GET,
                        null, Device.class, deviceId
                );
        return Optional.ofNullable(restExchange.getBody());
    }

}
