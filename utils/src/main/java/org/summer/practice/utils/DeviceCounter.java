package org.summer.practice.utils;

import org.summer.practice.common.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для подсчета одновременно включенных устройств
 */
public class DeviceCounter {
    private List<Device> devices = new ArrayList<>();

    public void register(Device device){
        devices.add(device);
    }

    public void unregister(Device device){
        devices.remove(device);
    }

    public Integer getDevicesCount() {
        return devices.size();
    }
}
