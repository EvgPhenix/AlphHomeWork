package com.alpha;

// пробовал так:
// например число 8
// b = 8 % 2 = 0
// b = 4 % 2 = 0
// b = 2 % 2 = 0
// b = 1 % 2 = 1
// и один встроенный метод

public class HomeWork_28_10_2018_NumToBinNum {
    static int num10 = 123;

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(num10));
        System.out.println(binar(num10));

    }
    public static String binar(int a) {
        StringBuilder bin = new StringBuilder();
        int b;
        while(a !=0 ) {
            b = a%2;
            bin.append(b);
            a = a/2;
        }
        bin.reverse();
        return bin.toString();
    }

}
