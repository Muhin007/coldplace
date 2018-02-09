package com.github.muhin007.coldplace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coldplace {

    public static void main(String[] args) throws Exception {
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
        Writer writer = null;
        try {
            writer = new FileWriter("Citylist.txt");
            for (City list : list) {
                writer.write();
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) try {
                writer.close();
            } catch (IOException ignored) {
            }
        }
        //Прочитали список городов из файла
        try {
            File file = new File("Citylist.txt");
            FileReader fr = new FileReader(file);
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
        int i;
        switch ( i = (int) d ) {
        }
        City foundedCity = null;
        for (City list : list) {
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
//Записываем в файл название города и случайное значение температуры
        FileWriter fw = new FileWriter("C:\\Dev\\Project\\coldplace\\maven\\src\\main\\" +
                "java\\com\\github\\muhin007\\coldplace\\City.txt");

        fw.write(name + " " + i);

        fw.close();
    }
}
