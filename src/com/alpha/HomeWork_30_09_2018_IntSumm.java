package com.alpha;

//сумма двух чисел
//принимает значения от - Integer.MIN_VALUE/2 до Integer.MAX_VALU/2

public class HomeWork_30_09_2018_IntSumm {

    public static void main(String[] args) {
        System.out.println(summ(5, 12));
        System.out.println(summ(-2, -3));
        System.out.println(summ(Integer.MIN_VALUE/2+1, Integer.MAX_VALUE/2));

        System.out.println(summ(Integer.MIN_VALUE/2-1, Integer.MAX_VALUE/2));
        System.out.println(summ(Integer.MIN_VALUE/2+1, Integer.MAX_VALUE/2+1));
        System.out.println(summ(Integer.MAX_VALUE/2+1, 2));
        System.out.println(summ(Integer.MIN_VALUE/2+1, Integer.MIN_VALUE/2-1));
    }
    public static int summ(int a, int b){
        try{

            if (a < Integer.MIN_VALUE/2 || a > Integer.MAX_VALUE/2) throw new Exception();
            if (b < Integer.MIN_VALUE/2 || b > Integer.MAX_VALUE/2) throw new Exception();

            return a + b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a + b;
    }
}
