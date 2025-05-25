package org.summer.practice.utils;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.summer.practice.common.AiPhone;
import org.summer.practice.common.AndroidPhone;
import org.summer.practice.common.Device;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeviceCounterTest {

    private DeviceCounter deviceCounter;
    private Device device1;
    private Device device2;

    @BeforeEach
    public void setUp() {
        deviceCounter = new DeviceCounter();
        device1 = new AiPhone(111, 111, (byte) 111); // Предполагаем, что Device - это реальный класс
        device2 = new AndroidPhone(111, 111, "Xiaomi");
    }

    @Test
    public void testInitialCountShouldBeZero() {
        assertEquals(0, deviceCounter.getDevicesCount());
    }

    @Test
    public void testRegisterDeviceIncreasesCount() {
        deviceCounter.register(device1);
        assertEquals(1, deviceCounter.getDevicesCount());

        deviceCounter.register(device2);
        assertEquals(2, deviceCounter.getDevicesCount());
    }

    @Test
    public void testUnregisterDeviceDecreasesCount() {
        deviceCounter.register(device1);
        deviceCounter.register(device2);

        deviceCounter.unregister(device1);
        assertEquals(1, deviceCounter.getDevicesCount());

        deviceCounter.unregister(device2);
        assertEquals(0, deviceCounter.getDevicesCount());
    }

    @Test
    public void testUnregisterNonExistentDeviceDoesNothing() {
        deviceCounter.register(device1);
        deviceCounter.unregister(device2); // device2 не был зарегистрирован

        assertEquals(1, deviceCounter.getDevicesCount());
    }

    @Test
    public void testRegisterSameDeviceTwiceIncreasesCountTwice() {
        deviceCounter.register(device1);
        deviceCounter.register(device1);

        assertEquals(2, deviceCounter.getDevicesCount());
    }

    @Test
    public void testUnregisterAllDevices() {
        deviceCounter.register(device1);
        deviceCounter.register(device2);

        deviceCounter.unregister(device1);
        deviceCounter.unregister(device2);

        assertEquals(0, deviceCounter.getDevicesCount());
    }
}