package com.github.muhin007.coldplace;

import org.junit.Assert;
import org.junit.Test;

public class CityTest {

    @Test
    public void calculateRandomTemperature() {
        City city = new City("testName", -30, -10);
        for (int i = 0; i < 10; i++) {
            int t = city.calculateRandomTemperature();
            Assert.assertTrue(t >= -30 && t < -10);
        }
    }
}