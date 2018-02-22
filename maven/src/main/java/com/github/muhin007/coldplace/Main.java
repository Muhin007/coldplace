package com.github.muhin007.coldplace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Программа показывает температуру в запрашиваемом городе");

        List<City> cities = new ArrayList<>();

        try {
            FileReader fr = new FileReader("CityRead.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] stringsArray = line.split(",", 3);
                String name= stringsArray[0];
                int minTemperature = Integer.parseInt(stringsArray[1].trim());
                int maxTemperature = Integer.parseInt(stringsArray[2].trim());
                cities.add(new City(name, minTemperature, maxTemperature));

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название города ");
        String name = sc.nextLine();

        City foundedCity = null;
        for (City city : cities) {
            if (name.equalsIgnoreCase(city.getName())) {
                foundedCity = city;
                break;
            }
        }

        if (foundedCity != null) {
            System.out.println("Сейчас в " + name + " " + foundedCity.calculateRandomTemperature());
        } else {
            System.out.println("Сейчас в " + name + " " + (new Random().nextInt(1) - 50));
        }

    }
}
