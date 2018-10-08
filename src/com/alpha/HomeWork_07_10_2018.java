package com.alpha;

public class HomeWork_07_10_2018 {
    public static int a = 3, b = 5;
    public static int c = 7, d = 12;

    public static void main(String[] args) {

        //тест задания №1 поиск подстроки
        String q = "jfbnelibwsxwwwqb";
        System.out.println(subString(q, 3));
        System.out.println(subString(q, 1));
        System.out.println(subString(q, 2));

        String zzz = "eeejjhdnmmcbrybddd_aaaooooosssgggewjnciwejjjjjpol";
        System.out.println(subString(zzz, 5));

        //это для дебага, надеюсь не мешает
//        StringBuilder ss = new StringBuilder(q);
//        ss.reverse();
//        System.out.println(ss);
//        System.out.println(ss.charAt(2));
//        System.out.println(ss.charAt(3));
//        System.out.println(ss.charAt(2) == ss.charAt(3));
//        System.out.println(q.substring(q.length()-5, 14));


        //тест задания №2 поменять местами значения переменных, не вводя дополнительные
        System.out.println("a " + a + " b " + b + " c " + c + " d " + d);
        reverse();
        System.out.println("a " + a + " b " + b + " c " + c + " d " + d);
    }


    //задание №1 поиск подстроки
    public static String subString(String string, int value){
        StringBuilder zopa = new StringBuilder(string);
        zopa.reverse();

        int counter = 1;
        int position = 0;
        if (value==1) return string.substring(string.length()-1);
        if (value>1){
            for (int i = 0; i < string.length()-1; i++) {
                 if (zopa.charAt(i)==zopa.charAt(i+1)){
                     counter++;
                 }
                 if (!(zopa.charAt(i)==zopa.charAt(i+1)) && counter==value){
                     position = i;
                     break;
                 }
                 if (!(zopa.charAt(i)==zopa.charAt(i+1)) && counter>value){
                     position = i;
                     break;
                 }
                 if (!(zopa.charAt(i)==zopa.charAt(i+1)) && counter<value){
                     counter = 1;
                 }
            }
        }
        //это для дебага, оставляю здесь, чтобы объяснить если что, что я наделал
        //System.out.println("position " + position + "\ncounter" + counter);

        return string.substring(string.length()-position-1, string.length()-position-1+counter);
    }

    //задание №2 поменять местами переменные не вводя дополнительную переменную
    public static void reverse(){
        a = a + b;
        b = a - b;
        a = a - b;

        c = c ^ d;
        d = c ^ d;
        c = c ^ d;

    }



}
