package com.github.muhin007.coldplace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.print("Вы не ввели ни один -ключ, поэтому посмотрите на случайное число ");
            System.out.println((new Random().nextInt(101) - 50));
            System.out.println(" и введите -h или --help для получения справки.");
        }
        if (args[0].equals("-h") || args[0].equals("--help")) {
            System.out.println("Программа Coldplace показывает температуру в запрашиваемом городе");
            System.out.println("-h, --help - помощь в использовании ключей командной строки;" +
                    "-с, --city <Название города> - покажет вам температуру в указанном городе;" +
                    "--city-list - покажет вам список названий всех доступных городов;" +
                    "-f и --data-file-path указанные после -с, --city, --city-list позволят указать путь к другому файлу сдругим списком городов" +
                    " p.s. запуск программы без ключа покажет случайную температуру");
            return;
        }
        if (args[0].equals("-c") || args[0].equals("--city")) {
            System.out.println("Программа Coldplace показывает температуру в запрашиваемом городе");

            List<City> cities = new ArrayList<>();

            try {
                if (args[1].equals("-f") || args[1].equals("--data-file-path")) {
                    File file = new File(args[2]);
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    while (line != null) {
                        String[] stringsArray = line.split(",", 3);
                        String name = stringsArray[0];
                        int minTemperature = Integer.parseInt(stringsArray[1].trim());
                        int maxTemperature = Integer.parseInt(stringsArray[2].trim());
                        cities.add(new City(name, minTemperature, maxTemperature));
                        line = reader.readLine();
                    }
                } else {
                    File file = new File("CityRead.txt");
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    while (line != null) {
                        String[] stringsArray = line.split(",", 3);
                        String name = stringsArray[0];
                        int minTemperature = Integer.parseInt(stringsArray[1].trim());
                        int maxTemperature = Integer.parseInt(stringsArray[2].trim());
                        cities.add(new City(name, minTemperature, maxTemperature));
                        line = reader.readLine();
                    }
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
                if (args[1].equals("-f") || args[1].equals("--data-file-path")) {
                    System.out.println("Города доступные для просмотра:");
                    File file = new File(args[2]);
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    while (line != null) {
                        String[] stringsArray = line.split(",", 3);
                        String name = stringsArray[0];
                        System.out.println(name);
                        line = reader.readLine();
                    }
                } else {
                    System.out.println("Города доступные для просмотра:");
                    File file = new File("CityRead.txt");
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    while (line != null) {
                        String[] stringsArray = line.split(",", 3);
                        String name = stringsArray[0];
                        System.out.println(name);
                        line = reader.readLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();//TODO log to file, not show to user

            }

        }
    }
}
