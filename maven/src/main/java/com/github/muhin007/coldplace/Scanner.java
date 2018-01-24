package com.github.muhin007.coldplace;

import java.util.Scanner;

public class Scanner {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Введите название города: ");
    String city = in.nextLine();
    System.out.println("Вы указали город: " + city);
    }
}
