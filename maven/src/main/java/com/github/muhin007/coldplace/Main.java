package com.github.muhin007.coldplace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        if (args[0].equals("-h") || args[0].equals("--help")) {
            System.out.println("Программа Coldplace показывает температуру в запрашиваемом городе");
            System.out.println("-h, --help - помощь в использовании ключей командной строки; " +
                    "-с, --city <Название города> - покажет вам температуру в указанном городе; " +
                    "--city-list - покажет вам список названий всех доступных городов; " +
                    "p.s. запуск программы без ключа покажет случайную температуру");
            return;
        }
        if (args[0].equals("-c") || args[0].equals("--city")) {
            System.out.println("Программа Coldplace показывает температуру в запрашиваемом городе");

            List<City> cities = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("CityRead.txt"))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] stringsArray = line.split(",", 3);
                    String name = stringsArray[0];
                    int minTemperature = Integer.parseInt(stringsArray[1].trim());
                    int maxTemperature = Integer.parseInt(stringsArray[2].trim());
                    cities.add(new City(name, minTemperature, maxTemperature));

                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); //TODO log to file, not show to user
            }

            City foundedCity = null;
            for (City city : cities) {
                if (args[1].equalsIgnoreCase(city.getName())) {
                    foundedCity = city;
                    break;
                }
            }

            if (foundedCity != null) {
                System.out.println("Сейчас в " + args[1] + " " + foundedCity.calculateRandomTemperature());
                return;
            }
        }
        if (args[0].equals("--city-list")) {
            try {

                FileReader fr = new FileReader("CityRead.txt");
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
            System.exit(0);
        } else {
            System.out.println((new Random().nextInt(101) - 50));
        }


    }
}


