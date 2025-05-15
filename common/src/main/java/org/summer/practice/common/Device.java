package org.summer.practice.common;

public abstract class Device {
    public final int batteryCapacity;
    protected final int serialNumber;
    private int batteryCharge;
    private boolean isTurnedOn = false;

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public Device(int serialNumber, int capacity) {
        this.serialNumber = serialNumber;
        batteryCapacity = capacity;
    }

    public void turnOn() {
        if (batteryCharge > 0) {
            isTurnedOn = true;
            System.out.printf("Устройство %d включено", serialNumber);
        }
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }
}
