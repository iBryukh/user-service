package com.smarthouse.user.service;

import com.smarthouse.commonutil.entities.*;
import junit.framework.TestCase;
import com.smarthouse.user.repository.UserDeviceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDeviceServiceImplJUnitTest extends TestCase {
    @Mock
    private static UserDeviceRepository deviceRepository;

    @InjectMocks
    private static UserDeviceServiceImpl service;

    @Test
    public void testFindRoleByID(){
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        Mockito.when(deviceRepository.findOne(userDeviceId)).thenReturn(userDevice);
        Optional<UserDevice> optionalUser = service.getById(userDeviceId);
        UserDevice userDevice1 = optionalUser.isPresent() ? optionalUser.get() : new UserDevice();


        Assert.assertEquals(userDevice, userDevice1);

    }

    @Test
    public void testFindAll(){
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        List<UserDevice> userDevices = new ArrayList<UserDevice>();
        userDevices.add(userDevice);
        when(deviceRepository.findAll()).thenReturn(userDevices);
        List<UserDevice> op1 =  service.getAll();

        Assert.assertEquals(1, op1.size());

    }
    @Test
    public void testDeleteById(){
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        service.deleteById(userDeviceId);
        Mockito.verify(deviceRepository, times(1)).delete(userDeviceId);

    }

    @Test
    public void testDeleteByRole(){
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        service.delete(userDevice);
        Mockito.verify(deviceRepository, times(1)).delete(userDevice);

    }

    @Test
    public void testBySave(){
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        Mockito.when(deviceRepository.saveAndFlush(userDevice)).thenReturn(userDevice);
        UserDevice op = service.save(userDevice);


        Assert.assertEquals(op, userDevice);

    }


}