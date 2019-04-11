package com.smarthouse.user.service;

import com.smarthouse.commonutil.entities.UserDevice;
import com.smarthouse.commonutil.entities.UserDeviceId;
import com.smarthouse.commonutil.service.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeviceServiceImpl extends CRUDServiceImpl<UserDevice, UserDeviceId> {

    @Autowired
    public UserDeviceServiceImpl(final JpaRepository<UserDevice, UserDeviceId> repository) {
        super(repository);
    }

}
