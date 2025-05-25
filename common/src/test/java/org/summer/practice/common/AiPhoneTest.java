package org.summer.practice.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AiPhoneTest {

    private AiPhone iPhone;
    private final int TEST_SERIAL_NUMBER = 12345;
    private final int TEST_CAPACITY = 3000;
    private final byte TEST_MODEL_NUMBER = 15;
    private final int TEST_PHONE_NUMBER = 5551234;


    @BeforeEach
    public void setUp() {
        iPhone = new AiPhone(TEST_SERIAL_NUMBER, TEST_CAPACITY, TEST_MODEL_NUMBER);
    }

    @Test
    public void testConstructorInitializesFieldsCorrectly() {
        assertEquals(TEST_SERIAL_NUMBER, iPhone.serialNumber);
        assertEquals(TEST_CAPACITY, iPhone.batteryCapacity);
        assertEquals(TEST_MODEL_NUMBER, iPhone.modelNumber);
    }

    @Test
    public void testTurnOnPrintsCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        iPhone.turnOn();

        String expectedOutput = String.format("%d айфон показал вам яблочко%n", TEST_MODEL_NUMBER);
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

    @Test
    public void testCallNumberPrintsCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        iPhone.callNumber(TEST_PHONE_NUMBER);

        String expectedOutput = String.format("Айфон звонит по номеру %d%n", TEST_PHONE_NUMBER);
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }

    @Test
    public void testToStringReturnsCorrectFormat() {
        String expectedString = String.format(
                "org.summer.practice.common.AiPhone{modelNumber=%d, BATTERY_CAPACITY=%d}",
                TEST_MODEL_NUMBER, TEST_CAPACITY
        );
        assertEquals(expectedString, iPhone.toString());
    }

    @Test
    public void testEqualsWithSameSerialNumberReturnsTrue() {
        AiPhone sameIPhone = new AiPhone(TEST_SERIAL_NUMBER, 2500, (byte)14);
        assertTrue(iPhone.equals(sameIPhone));
    }

    @Test
    public void testEqualsWithDifferentSerialNumberReturnsFalse() {
        AiPhone differentIPhone = new AiPhone(54321, TEST_CAPACITY, TEST_MODEL_NUMBER);
        assertFalse(iPhone.equals(differentIPhone));
    }

    @Test
    public void testEqualsWithNullReturnsFalse() {
        assertFalse(iPhone.equals(null));
    }

    @Test
    public void testEqualsWithDifferentClassReturnsFalse() {
        Object obj = new Object();
        assertFalse(iPhone.equals(obj));
    }

    @Test
    public void testHashCodeConsistentWithEquals() {
        AiPhone sameIPhone = new AiPhone(TEST_SERIAL_NUMBER, 2500, (byte)14);
        assertEquals(iPhone.hashCode(), sameIPhone.hashCode());
    }
}
