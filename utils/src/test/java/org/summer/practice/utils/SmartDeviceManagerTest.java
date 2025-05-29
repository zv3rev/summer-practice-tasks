package org.summer.practice.utils;

import org.junit.jupiter.api.Test;
import org.summer.practice.common.AiPhone;
import org.summer.practice.common.AndroidPhone;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SmartDeviceManagerTest {
    private final DeviceCounter counter = mock();
    private final SmartDeviceManager manager = new SmartDeviceManager(counter);
    private final AiPhone iPhone = new AiPhone(1, 3000, (byte)14);
    private final AndroidPhone android = new AndroidPhone(2, 4000, "Samsung");

    @Test
    public void testConnectDevice() {
        manager.connectDevice(iPhone);
        assertTrue(manager.getDeviceStatistics().contains("iPhone: 1"));
    }

    @Test
    public void testDeviceStatistics() {
        manager.connectAll(iPhone, android, new AiPhone(3, 3500, (byte)15));
        String stats = manager.getDeviceStatistics();
        assertTrue(stats.contains("iPhone: 2"));
        assertTrue(stats.contains("Android: 1"));
    }

    @Test
    public void testGetConnectedCount(){
        when(counter.getDevicesCount()).thenReturn(1);

        assertEquals(1, manager.getConnectedCount());

        verify(counter).getDevicesCount();
    }
}