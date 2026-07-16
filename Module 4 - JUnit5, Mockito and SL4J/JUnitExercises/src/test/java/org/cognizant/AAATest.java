package org.cognizant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAATest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() {
        System.out.println("Before Test");
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Test");
        calculator = null;
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 20;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 5;
        int b = 6;
        // Act
        int result = calculator.multiply(a, b);
        // Assert
        assertEquals(30, result);
    }
}
