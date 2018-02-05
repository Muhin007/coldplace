package com.github.muhin007.coldplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Coldplace {

    public static void main(String[] args) {
        System.out.println("Программа показывает температуру в запрашиваемом городе");

        List<City> list = new ArrayList<City>();
        list.add(new City("Москва", -20, -5));
        list.add(new City("Санкт-Петербург", -15, 0));
        list.add(new City("Новосибирск", -25, -15));
        list.add(new City("Магадан", -40, -20));
        list.add(new City("Владивосток", -20, -10));

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название города ");
        String name = sc.nextLine();

        City foundedCity = null;
        for (City city : list) {
            if (city.name.equals(name)) {
                foundedCity = city;
                break;
            }
        }

//        City city = list.get(0);
//        double d = (Math.abs(city.maxTemperature - city.minTemperature) * r.nextDouble()) + city.minTemperature;
//        int i = (int) d;

        Random r = new Random();
        int i = r.nextInt();//доработать выдачу случайного числа из диапазона температур для каждого города
        int x = r.nextInt(101) - 50;

        if (foundedCity != null) {
            System.out.println("Сейчас в " + name + " " + foundedCity.calculateRandomTemperature());
        } else {
            System.out.println("Сейчас в " + name + " " + x);

        }
    }
}