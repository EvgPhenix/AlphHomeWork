package com.alpha.HomeWorkTesting;

import java.util.ArrayList;

public class test {
    public static ArrayList<Integer> mersenNumbers = new ArrayList<>();

    public static void main(String[] args) {
        mersenNumbers.add(2);
        mersenNumbers.add(4);
        mersenNumbers.add(6);
        mersenNumbers.add(12);
        mersenNumbers.add(16);
        mersenNumbers.add(18);
        mersenNumbers.add(30);


        System.out.println(mersenNumbers.size());
        System.out.println(mersenNumbers.remove(0));
        System.out.println(mersenNumbers.size());

        int a = -2*(2^1)^2-(2^1)-1;
        double b = 2 * Math.pow((Math.pow(2, 1)), 2) - Math.pow(2, 1) ;
        double c = 2 * Math.pow((Math.pow(2, 6)), 2) - Math.pow(2, 6) ;
        System.out.println(c);

    }
}
