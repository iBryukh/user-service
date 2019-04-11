package com.smarthouse.user.repository;

import com.smarthouse.commonutil.entities.UserDevice;
import com.smarthouse.commonutil.entities.UserDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice, UserDeviceId> {

    @Query(
            value = "SELECT cd.device_id from customer_device cd where cd.customer_id = :customer_id",
            nativeQuery = true
    )
    public Collection<Long> findUserDevicesIds(@Param("customer_id") Long userId);

}
