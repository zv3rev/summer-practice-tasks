package org.summer.practice.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VacuumBotTest {
    @Test
    void constructor_ShouldInitializeFieldsCorrectly() {
        // Arrange & Act
        VacuumBot bot = new VacuumBot(12345, 5000, 2000);

        // Assert
        assertEquals(12345, bot.getSerialNumber());
        assertEquals(5000, bot.batteryCapacity);
        assertEquals(2000, bot.wattage);
    }

    @Test
    void turnOn_ShouldInvokeParentMethodAndPrintMessages() {
        // Arrange
        VacuumBot bot = new VacuumBot(12345, 5000, 2000);
        VacuumBot spyBot = spy(bot);

        // Act
        spyBot.turnOn();

        // Assert
        assertFalse(spyBot.isTurnedOn());
    }

    @Test
    void toString_ShouldReturnCorrectFormat() {
        // Arrange
        VacuumBot bot = new VacuumBot(12345, 5000, 2000);

        // Act
        String result = bot.toString();

        // Assert
        String expected = "org.summer.practice.common.VacuumBot{" +
                "wattage=2000" +
                ", BATTERY_CAPACITY=5000" +
                "}";
        assertEquals(expected, result);
    }

}