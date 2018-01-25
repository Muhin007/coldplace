package com.github.muhin007.coldplace;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("coldplace");

        CityScanner in = new CityScanner(System.in);
        System.out.print("Введите название города: ");
        String city = in.nextLine();
        System.out.println("Вы указали город: " + city);

        List<City> list = new ArrayList<>();
        list.add(new City("Москва", -20, -5));
//        list.add("Санкт-Петербург");
//        list.add("Челябинск");
//        list.add("Новосибирск");
//        list.add("Магадан");
//        list.add("Владивосток");

    }

}
