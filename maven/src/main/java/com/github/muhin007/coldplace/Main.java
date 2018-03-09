package com.github.muhin007.coldplace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if ( args[0].equals("-h") )
            System.out.println( "-h, --help - помощь в использовании ключей командной строки; " +
                    "-с, --city - температуру в указанном городе; --city-list - список названий городов;" +
                    " запуск программы без ключа покажет случайную темературу в случайном городе");
        if ( args[1].equals("--help") )
            System.out.println( "-h, --help - помощь в использовании ключей командной строки;" +
                    "-с, --city - температуру в указанном городе; --city-list - список названий городов;" +
                    " запуск программы без ключа покажет случайную темературу в случайном городе");
        if ( args[2].equals("-c") )
            System.out.println("Введите название города");
        if ( args[3].equals("--city") )
            System.out.println( "Введите название города" );
        if ( args[4].equals("--city-list") )
            System.out.println( "Список городов" );
        else System.out.println( "Случайную температуру");

        System.out.println("Программа показывает температуру в запрашиваемом городе");

        List<City> cities = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("CityRead.txt"))) {
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
            e.printStackTrace(); //TODO log to file, not show to user
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
