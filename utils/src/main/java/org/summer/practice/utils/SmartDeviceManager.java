package org.summer.practice.utils;

import org.summer.practice.common.AiPhone;
import org.summer.practice.common.AndroidPhone;
import org.summer.practice.common.Device;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmartDeviceManager {
    private final DeviceCounter counter = new DeviceCounter();
    private final List<Device> connectedDevices = new ArrayList<>();
    private final List<String> deviceNotifications = new ArrayList<>();

    /**
     * Регистрирует устройство и подключает его к менеджеру
     */
    public void connectDevice(Device device) {
        device.turnOn();
        counter.register(device);
        connectedDevices.add(device);
        addNotification("Устройство подключено: " + device.getClass().getSimpleName());
    }

    /**
     * Массовое подключение устройств
     */
    public void connectAll(Device... devices) {
        for (Device device : devices) {
            connectDevice(device);
        }
    }

    /**
     * Возвращает статистику по подключенным устройствам
     */
    public String getDeviceStatistics() {
        long iphones = connectedDevices.stream()
                .filter(AiPhone.class::isInstance)
                .count();

        long androids = connectedDevices.stream()
                .filter(AndroidPhone.class::isInstance)
                .count();

        return String.format("Подключено устройств: %d (iPhone: %d, Android: %d)",
                connectedDevices.size(), iphones, androids);
    }

    /**
     * Возвращает последние уведомления
     */
    public List<String> getRecentNotifications(int count) {
        return deviceNotifications.stream()
                .skip(Math.max(0, deviceNotifications.size() - count))
                .collect(Collectors.toList());
    }

    private void addNotification(String message) {
        deviceNotifications.add("[" + System.currentTimeMillis() + "] " + message);
    }
}