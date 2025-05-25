package org.summer.practice.aggregator;

import org.junit.jupiter.api.Test;
import org.summer.practice.common.*;
import org.summer.practice.utils.DeviceCounter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final DeviceCounter counter = new DeviceCounter();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testMainDemonstratesPolymorphism() {
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Xiaomi"));
        assertTrue(output.contains("айфон показал вам яблочко"));
        assertTrue(output.contains("VacuumBot"));

        System.setOut(System.out);
    }

    @Test
    public void testIPhoneEqualsAndHashCode() {
        AiPhone iPhone1 = new AiPhone(15, 10, (byte)13);
        AiPhone iPhone2 = new AiPhone(15, 20, (byte)13);

        assertEquals(iPhone1, iPhone2);
        assertEquals(iPhone1.hashCode(), iPhone2.hashCode());
    }

    @Test
    public void testDeviceArrayContainsAllTypes() {
        Device[] devices = {
                new AndroidPhone(1, 20, "Xiaomi"),
                new AiPhone(2, 10, (byte)13),
                new VacuumBot(3, 5, 200)
        };

        assertEquals(3, devices.length);
        assertInstanceOf(AndroidPhone.class, devices[0]);
        assertInstanceOf(AiPhone.class, devices[1]);
        assertInstanceOf(VacuumBot.class, devices[2]);
    }

    @Test
    public void testCounterWithMultipleDevices() {
        Device[] devices = {
                new AndroidPhone(1, 20, "Xiaomi"),
                new AiPhone(2, 10, (byte)13),
                new VacuumBot(3, 5, 200)
        };

        for (Device device : devices) {
            counter.register(device);
        }

        assertEquals(3, counter.getDevicesCount());
    }
}