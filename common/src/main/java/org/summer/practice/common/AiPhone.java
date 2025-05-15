package org.summer.practice.common;

import java.util.Objects;

public class AiPhone extends Device implements Phone{
    public final byte modelNumber;

    public AiPhone(int serialNumber, int capacity, byte modelNumber) {
        super(serialNumber, capacity);
        this.modelNumber = modelNumber;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.printf("%d айфон показал вам яблочко%n", modelNumber);
    }

    @Override
    public String toString() {
        return "org.summer.practice.common.AiPhone{" +
                "modelNumber=" + modelNumber +
                ", BATTERY_CAPACITY=" + batteryCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AiPhone aiPhone)) return false;
        return serialNumber == aiPhone.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public void callNumber(Integer number) {
        System.out.printf("Айфон звонит по номеру %d%n", number);
    }
}
