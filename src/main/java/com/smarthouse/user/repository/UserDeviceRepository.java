package com.smarthouse.user.repository;

import com.smarthouse.commonutil.entities.UserDevice;
import com.smarthouse.commonutil.entities.UserDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice, UserDeviceId> {
}
