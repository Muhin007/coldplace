package com.github.muhin007.coldplace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Программа показывает температуру в запрашиваемом городе");

//Создали список городов
        List<City> list = new ArrayList<>();
        list.add(new City("Москва", -20, -5));
        list.add(new City("Челябинск", -25, -10));
        list.add(new City("Санкт-Петербург", -15, 0));
        list.add(new City("Новосибирск", -25, -15));
        list.add(new City("Магадан", -40, -20));
        list.add(new City("Владивосток", -20, -10));
//Записали список городов в файл
        FileWriter writer = new FileWriter("Citylist.txt");
        for (City news : list) {
            String name = news.getName();
            int minTemperature = news.getMinTemperature();
            int maxTemperature = news.getMaxTemperature();

            writer.write(name + " " + minTemperature + " " + maxTemperature + System.getProperty("line.separator"));
        }
        writer.close();

        //Прочитали список городов из файла
        try {

            FileReader fr = new FileReader("Citylist.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//Приняли название города с консоли
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название города ");
        String name = sc.nextLine();
//Сравниваем введенный город со списком и получаем случайную температуру
        City city = list.get(0);
        double d = (Math.abs(city.getMaxTemperature() - city.getMinTemperature()) * r.nextDouble()) + city.getMinTemperature();
        int i = (int) d;
        {
        }
        City foundedCity = null;
        for (City city : list) {
            if (city.name.equals(name)) {
                foundedCity = city;
                break;
            }
        }
//Ввели случайный выбор температур если введенного города нет в списке
        Random r = new Random();
        int x = r.nextInt(101) - 50;
//выводим на экран название города и случайное значение температуры
        if (foundedCity != null) {
            System.out.println("Сейчас в " + name + " " + i);
        } else {
            System.out.println("Сейчас в " + name + " " + x);

        }
    }
}
