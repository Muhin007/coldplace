package com.github.muhin007.coldplace;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

        private static int isArgsContainsKey(String[] args, String key) {
            if (args != null && args.length > 0) {
                ArrayList<String> list = new ArrayList<>(Arrays.asList(args));
                int index = list.indexOf(key);
                list.clear();
                return index;
            }
            return -1;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.print("Вы не ввели ни один -ключ, поэтому посмотрите на случайное число ");
            System.out.println((new Random().nextInt(101) - 50));
            System.out.println(" и введите -h или --help для получения справки.");
        }
        if (args[0].equals("-h") || args[0].equals("--help")) {
            System.out.println("Программа Coldplace показывает температуру в запрашиваемом городе");
            System.out.println("-h, --help - помощь в использовании ключей командной строки;\n" +
                    "-с, --city <Название города> - покажет вам температуру в указанном городе;\n" +
                    "--city-list - покажет вам список названий всех доступных городов;\n" +
                    "-f и --data-file-path указанные после -с, --city, --city-list позволят \n " +
                    "указать путь к другому файлу с другим списком городов\n" +
                    " p.s. запуск программы без ключа покажет случайную температуру");
            return;
        }

        String filePath = "CityRead.txt";
        if (isArgsContainsKey(args, "-f") || isArgsContainsKey(args, "--data-file-path")) {
            filePath = "CityReadEng.txt";
            int index = "a".indexOf(filePath);
            if (index != -1) {
                filePath = "CityRead.txt";
            } else {
                filePath = "CityReadEng.txt";
            }
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
                    nameCityRead(cities, reader, line);
                } else {
                    File file = new File("CityRead.txt");
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    nameCityRead(cities, reader, line);
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
                    nameCityList(reader, line);
                } else {
                    System.out.println("Города доступные для просмотра:");
                    File file = new File("CityRead.txt");
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    nameCityList(reader, line);
                }
            } catch (IOException e) {
                e.printStackTrace();//TODO log to file, not show to user
            }
        }
    }

    private static void nameCityList(BufferedReader reader, String line) throws IOException {
        while (line != null) {
            String[] stringsArray = line.split(",", 3);
            String name = stringsArray[0];
            System.out.println(name);
            line = reader.readLine();
        }
    }

    private static void nameCityRead(List<City> cities, BufferedReader reader, String line) throws IOException {
        while (line != null) {
            String[] stringsArray = line.split(",", 3);
            String name = stringsArray[0];
            int minTemperature = Integer.parseInt(stringsArray[1].trim());
            int maxTemperature = Integer.parseInt(stringsArray[2].trim());
            cities.add(new City(name, minTemperature, maxTemperature));
            line = reader.readLine();
        }
    }
}
