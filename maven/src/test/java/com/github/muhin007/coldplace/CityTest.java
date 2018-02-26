package com.github.muhin007.coldplace;

import org.junit.Test;

import java.util.Random;

public class CityTest {

    @Test
    public void calculateRandomTemperature() {
        Random r = new Random();
        int minTemperature = -30;
        int maxTemperature = -10;
        double d = (Math.abs((maxTemperature - minTemperature) * r.nextDouble()) + minTemperature);
        int actual = (int) d;
        if (actual >= -30 && actual <= -10) {
            System.out.print("Тест пройден");}
         else {
            System.out.print("Тест не пройден");
        }
    }
}