package com.alpha.HomeWorkTesting;

import java.math.BigInteger;

// Сумма совершенных чисел
public class HomeWork_21_10_2018 {
    public static void main(String[] args) {

        System.out.println(searchCub());


    }

    public static BigInteger searchCub(){

        long COUNT_ITEM_SEQ = Long.MAX_VALUE;
        BigInteger ss, bi, compare, summ;
        summ = new BigInteger("0");
        ss = new BigInteger("0");
        bi = new BigInteger("0");
        compare = new BigInteger("2305843008139952128");  // Сов. число, до которого ищется сумма кубов
        long i;    // переменная цикла, которая + 1, и есть число кубов

        summ = summ.add(new BigInteger(Long.toString(searchFirst()))); //ищем первое число алгоритмом в лоб)
        System.out.println(summ);

        for( i = 0; i <= COUNT_ITEM_SEQ; i++) {
            bi = BigInteger.valueOf(2*i+1).pow(3);     // куб нечетного натурального числа
            ss =ss.add(bi);
//            System.out.println(i + 1);

            // проверяем является ли номер данного куба степенью числа 2
            // если да, то проверяем, является ли число совершенным
            long n = i + 1;
            System.out.println(n + " n");
            if((n > 0) && ((n & (n - 1)) == 0)){
                if (verifyPerfection(ss)) {
                    summ.add(ss);
                    System.out.println(ss);
                }
            }

            if(compare.compareTo(ss) == 0)
                break;
        } // end for




//        System.out.println(i + 1);  // т.к. i начинается с нуля
        return summ;
    }


    public static boolean verifyPerfection(BigInteger number){
        long obrab = number.longValue();
        long delitelSumm = 0l;
        for (long j = 1; j < obrab; j++) {
            if (obrab % j == 0) {
                delitelSumm += j;
                if (obrab == delitelSumm) return true;
            }
        }
        if (obrab == delitelSumm) return true;
        else return false;
    }

    // прямой поиск (нормально находит 4 числа, пятое 10 мин и более)
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
