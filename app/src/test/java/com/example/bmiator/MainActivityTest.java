package com.example.bmiator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainActivityTest {

    @Test
    public void testUnderweight() {
        String status = MainActivity.calculateBmiStatus(45f, 170f);
        assertEquals("Underweight", status);
    }

    @Test
    public void testOptimal() {
        String status = MainActivity.calculateBmiStatus(65f, 170f);
        assertEquals("Optimal", status);
    }

    @Test
    public void testOverweight() {
        String status = MainActivity.calculateBmiStatus(78f, 170f);
        assertEquals("Overweight", status);
    }

    @Test
    public void testObesity() {
        String status = MainActivity.calculateBmiStatus(95f, 170f);
        assertEquals("Obesity", status);
    }

    @Test
    public void testInvalidInput() {
        assertEquals("Error", MainActivity.calculateBmiStatus(0f, 170f));
        assertEquals("Error", MainActivity.calculateBmiStatus(60f, 0f));
    }
}
