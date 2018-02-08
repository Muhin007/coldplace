package com.github.muhin007.coldplace;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coldplace {

    public static void main(String[] args) throws Exception{
        System.out.println("Программа показывает температуру в запрашиваемом городе");

        List<City> list = new ArrayList<>();
        list.add(new City("Москва", -20, -5));
        list.add(new City("Челябинск", -25, -10));
        list.add(new City("Санкт-Петербург", -15, 0));
        list.add(new City("Новосибирск", -25, -15));
        list.add(new City("Магадан", -40, -20));
        list.add(new City("Владивосток", -20, -10));

        Writer writer = null;
        try {
            writer = new FileWriter("ListCity.txt");
            for (City list : list) {
                writer.write(list);
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e) {
            Logger.getLogger(Coldplace.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ignored) {
                }
            }
        }

        Random r = new Random();
        int x = r.nextInt(101) - 50;

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

        if (foundedCity != null) {
            System.out.println("Сейчас в " + name + " " + foundedCity.calculateRandomTemperature());
        } else {
            System.out.println("Сейчас в " + name + " " + x);
        }
        
        FileWriter fw = new FileWriter("C:\\Dev\\Project\\coldplace\\maven\\src\\main\\" +
                "java\\com\\github\\muhin007\\coldplace\\City.txt");

            fw.write(name + " " + foundedCity.calculateRandomTemperature());

            fw.close();
    }
}
