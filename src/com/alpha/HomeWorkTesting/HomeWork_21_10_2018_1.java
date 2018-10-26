package com.alpha.HomeWorkTesting;

import java.util.ArrayList;

public class HomeWork_21_10_2018_1 {
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

//    public static Long serchPerfectNumbers (){
//        Long ss = 0l,  summ = 0l;
//        double bi = 0l;
//        summ = searchFirst();
//        System.out.println(summ);
//        for (double i = 0; i < Long.MAX_VALUE; i++) {
//            bi = Math.pow((2*i+1), 3);
//            ss += (long)bi;
//
//            int mersen = mersenNumbers.get(0);
//            double n = i+1;
////            System.out.println(mersen + " mersen");
//            if (n == Math.pow(2, mersen)){
//                System.out.println(ss);
//                mersenNumbers.remove(0);
//                summ += ss;
//            }
//        }
//        return summ;
//    }


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
    public static Long searchFirst(){
        int colvoChisel = 0;
        Long summ = 0l;
        Long lonDeliteli = 0l;
        for (long i = 2; i < Long.MAX_VALUE; i+=2) {
            for (long j = 1; j < i; j++) {
                if (i % j == 0){
                    lonDeliteli+=j;
                }
            }
            if (i == lonDeliteli){
                summ += i;
                colvoChisel ++;
            }
            lonDeliteli = 0l;
            if (colvoChisel == 1) break;
        }
        return summ;
    }
}
