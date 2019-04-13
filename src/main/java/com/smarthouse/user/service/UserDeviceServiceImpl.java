package com.smarthouse.user.service;

import com.smarthouse.commonutil.entities.UserDevice;
import com.smarthouse.commonutil.entities.UserDeviceId;
import com.smarthouse.commonutil.service.CRUDServiceImpl;
import com.smarthouse.user.repository.UserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDeviceServiceImpl extends CRUDServiceImpl<UserDevice, UserDeviceId> {

    private UserDeviceRepository repository;

    @Autowired
    public UserDeviceServiceImpl(final JpaRepository<UserDevice, UserDeviceId> repository) {
        super(repository);
        this.repository = (UserDeviceRepository) repository;
    }

    public Collection<Long> getUserDevicesIds(Long customerId) {
        return repository.findUserDevicesIds(customerId);
    }

}
