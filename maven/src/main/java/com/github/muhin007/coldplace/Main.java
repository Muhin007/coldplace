package com.github.muhin007.coldplace;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.println("-h, --help - помощь в использовании ключей командной строки;\n" +
                    "-с, --city <Название города> - покажет вам температуру в указанном городе;\n" +
                    "-l, --city-list - покажет вам список названий всех доступных городов;\n" +
                    "-f, --data-file-path <Название файла с городами> позволят указать\n " +
                    "путь к другому файлу с другим списком городов\n" +
                    " p.s. запуск программы без ключа покажет случайную температуру");
            return;
        }

        String filePath = "CityRead.txt";
        int indexKeyF = indexArgsKey(args, "-f", "--data-file-path");
        if (indexKeyF >= 0) {
            filePath = args[indexKeyF + 1];
        }

        String cityName = null;
        int indexKeyC = indexArgsKey(args, "-c", "--city");
        if (indexKeyC >= 0) {
            if (args.length > indexKeyC + 1) {
                cityName = args[indexKeyC + 1];

                List<City> cities = readCities(filePath);
                City foundedCity = null;
                for (City city : cities) {
                    if (cityName.equalsIgnoreCase(city.getName())) {
                        foundedCity = city;

                        break;
                    }
                }

                if (foundedCity != null) {
                    System.out.println("Сейчас в " + cityName + " " + foundedCity.calculateRandomTemperature());
                    return;
                }
                if (foundedCity == null){
                    return;
                }

            } else {
                System.out.println("Вы не указали название города или его нет в списке.\n" +
                        "Обратитесь -h, --help для получения справки.");
                return;
            }
        }
        int indexKeyCL = indexArgsKey(args, "-l", "--city-list");
        if (indexKeyCL >= 0) {
            try {
                File file = new File(filePath);
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8.name()));
                String line = reader.readLine();
                while (line != null) {
                    String[] stringsArray = line.split(",", 3);
                    String cities = stringsArray[0];
                    System.out.println(cities);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<City> readCities(String filePath) {
        List<City> cities = new ArrayList<>();
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8.name()));
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
            e.printStackTrace();
        }
        return cities;
    }


    private static int indexArgsKey(String[] args, String key, String longKey) {
        int indexKey = Arrays.asList(args).indexOf(key);
        if (indexKey >= 0) {
            return indexKey;
        }
        int indexLongKey = Arrays.asList(args).indexOf(longKey);
        if (indexLongKey >= 0) {
            return indexLongKey;
        }
        return -1;
    }

}
