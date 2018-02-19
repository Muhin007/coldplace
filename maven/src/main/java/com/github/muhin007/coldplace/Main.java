package com.github.muhin007.coldplace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Программа показывает температуру в запрашиваемом городе");

        List<City> list = new ArrayList<>();
        list.add(new City("Москва", -20, -5));
        list.add(new City("Челябинск", -25, -10));
        list.add(new City("Санкт-Петербург", -15, 0));
        list.add(new City("Новосибирск", -25, -15));
        list.add(new City("Магадан", -40, -20));
        list.add(new City("Владивосток", -20, -10));

        FileWriter writer = new FileWriter("Citylist.txt");
        for (City news : list) {
            String name = news.getName();
            int minTemperature = news.getMinTemperature();
            int maxTemperature = news.getMaxTemperature();

            writer.write(name + " " + minTemperature + " " + maxTemperature + System.getProperty("line.separator"));
        }
        writer.close();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название города ");
        String name = sc.nextLine();

        City foundedCity = null;
        for (City city : list) {
            if (city.name.equals(name)) {
                foundedCity = city;
                break;
            }
        }

        Random r = new Random();
        for (City city :list){
            int minTemperature = city.getMinTemperature();
            int maxTemperature = city.getMaxTemperature();
            double d = (Math.abs((maxTemperature - minTemperature) * r.nextDouble()) + minTemperature);
            int i = (int) d;
            int x = r.nextInt(101) - 50;


            if (foundedCity != null) {
                System.out.println("Сейчас в " + name + " " + i);
            } else {
                System.out.println("Сейчас в " + name + " " + x);

            }

        }
    }
}
