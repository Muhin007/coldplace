package com.github.muhin007.coldplace;

import java.util.Random;

class Random{
    public static void main(String[] args){
        Random r = new Random();
        int i = 0;
        int q = r.nextInt(101) - 50;
        System.out.println(q);
    }
}
