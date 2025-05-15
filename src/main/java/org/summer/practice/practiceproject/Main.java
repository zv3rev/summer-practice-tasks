package org.summer.practice.practiceproject;

import org.summer.practice.common.AiPhone;
import org.summer.practice.common.AndroidPhone;
import org.summer.practice.common.Device;
import org.summer.practice.common.VacuumBot;
import org.summer.practice.utils.DeviceCounter;

/*
Необходимо выстроить иерархию из абстрактного класса и 3 его реализаций.
На основе построенной иерархии продемонстрировать реализацию принципа полиморфизма в Java.
Так же продемонстрировать работу методов equals() и hashCode()
 */
public class Main {
    private static final DeviceCounter counter = new DeviceCounter();

    public static void main(String[] args) {
        Device[] devices = new Device[3];
        devices[0] = new AndroidPhone(1, 20, "Xiaomi");
        devices[1] = new AiPhone(2, 10, (byte) 13);
        devices[2] = new VacuumBot(3, 5, 200);

        for (Device dev : devices) {
            System.out.println(dev);
            dev.turnOn();
        }
        System.out.println();

        AiPhone iPhone1 = new AiPhone(15, 10, (byte) 13);
        AiPhone iPhone2 = new AiPhone(15, 20, (byte) 13);
        System.out.println(iPhone1);
        System.out.println(iPhone2);
        System.out.println("Сравниваем объекты:" + iPhone1.equals(iPhone2));
        System.out.println("Hash-код айфона: " + iPhone1.hashCode());

        turnOnAndRegister(iPhone1);
        turnOnAndRegister(iPhone2);
        System.out.printf("Одновременно включено устройств: " + counter.getDevicesCount());
    }

    private static void turnOnAndRegister(Device device){
        device.turnOn();
        counter.register(device);
    }
}
