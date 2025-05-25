package org.summer.practice.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class AndroidPhoneTest {
    private AndroidPhone androidPhone;
    private final int TEST_SERIAL_NUMBER = 12345;
    private final int TEST_CAPACITY = 3000;
    private final String TEST_BRAND = "Xiaomi";

    @BeforeEach
    public void setUp() {
        androidPhone = new AndroidPhone(TEST_SERIAL_NUMBER, TEST_CAPACITY, TEST_BRAND);
    }

    @Test
    public void testConstructorInitializesFieldsCorrectly() {
        assertEquals(TEST_SERIAL_NUMBER, androidPhone.serialNumber);
        assertEquals(TEST_CAPACITY, androidPhone.batteryCapacity);
        assertEquals(TEST_BRAND, androidPhone.brand);
    }

    @Test
    public void testToStringReturnsCorrectFormat() {
        String expectedString = String.format(
                "org.summer.practice.common.AndroidPhone{brand='%s', BATTERY_CAPACITY=%d}",
                TEST_BRAND, TEST_CAPACITY
        );
        assertEquals(expectedString, androidPhone.toString());
    }
}