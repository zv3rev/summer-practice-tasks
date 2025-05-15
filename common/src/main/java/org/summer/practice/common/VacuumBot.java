package org.summer.practice.common;

public class VacuumBot extends Device {
    public final int wattage;

    public VacuumBot(int serialNumber, int capacity, int wattage) {
        super(serialNumber, capacity);
        this.wattage = wattage;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Начинаю уборку");
        startEngines();
    }

    @Override
    public String toString() {
        return "org.summer.practice.common.VacuumBot{" +
                "wattage=" + wattage +
                ", BATTERY_CAPACITY=" + batteryCapacity +
                '}';
    }

    private void startEngines() {
        System.out.println("Врум-вжух!");
    }
}
