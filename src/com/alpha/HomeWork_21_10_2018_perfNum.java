package com.alpha;

import java.util.ArrayList;


// Поиск суммы первых восьми совершенных чисел
// Искал по формуле (2*n^2)-(2^n), где n = число Мерсена - 1

public class HomeWork_21_10_2018_perfNum {
    public static ArrayList<Integer> mersenNumbers = new ArrayList<>();

    public static void main(String[] args) {
        mersenNumbers.add(1);
        mersenNumbers.add(2);
        mersenNumbers.add(4);
        mersenNumbers.add(6);
        mersenNumbers.add(12);
        mersenNumbers.add(16);
        mersenNumbers.add(18);
        mersenNumbers.add(30);

        System.out.println(serchPerfectNumbers());

    }

    public static Long serchPerfectNumbers (){
        Long summ = 0l;
        for (int i = 0; i < 8; i++) {
            int mersen = mersenNumbers.remove(0);
//            System.out.println(mersen + " mersen");
            double perf = (2 * Math.pow((Math.pow(2, mersen)), 2) - Math.pow(2, mersen));
//            System.out.println((long) perf);
            summ += (long) perf;

        }
        return summ;
    }
}
