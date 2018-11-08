package com.alpha;

import java.math.BigInteger;

// Решено 4-мя (на самом деле тремя)) способами:
// с помощью рекурсии
// с помощью цикла
// с помощью формулы Бине (пытался сам вывести и доказать ее, но нИАсилил((
// с помощью возведения в степень матриц алгоритмом быстрого возведения в степень

public class HomeWork_28_10_2018_Fibo {
    public static void main(String[] args) {
        System.out.println("Поиск рекурсивно элемент 45: " + fibo1(45));

        System.out.println("Поиск с помощью цикла элемент 11: " + fibo2(11));

        System.out.println("Поиск по формуле Бине элемент 70: " + fibBine(70));
        System.out.println("Далее с помощью возведения в степень матриц:");
        System.out.println(1024+": "+pow(ONE, 1024)[0][1]);
        System.out.println(4096+": "+pow(ONE, 4096)[0][1]);
        BigInteger z = BigInteger.valueOf(1000);
        System.out.println(4096+": "+pow(ONE, 4096)[0][1].divide(z));
    }

    // рекурсивно
    public static int fibo1 (int i){
        if (i == 1) return 1;
        if (i == 2) return 1;
        return fibo1(i - 1) + fibo1(i - 2);
    }

    // c помощью цикла
    public static int fibo2(int n){
        int a = 1, b = 1;
//        System.out.print(a + " " + b);
        int fib = 2, i = 2;
        while (i < n) {
            fib = a + b;
            a = b;
            b = fib;
//            System.out.print(" " + fib);
            i++;
        }
        return fib;
    }
    // по формуле Бине (хороший алгоритм O(log n)), но после 70-го элемента погрешность большая
    public static long fibBine(final long n)
    {
        double p = (1 + Math.sqrt(5)) / 2;
        double q = 1 / p;
        return (long) ((Math.pow(p, n) + Math.pow(q, n)) / Math.sqrt(5));
    }

    // с помощью возведения в степень матриц:
    // | F0, F1 | = | 0 1 |  = One
    // | F1, F2 |   | 1 1 |
    // произведение матриц
    // [ F(n-2), F(n-1) ] * One = [ F(n-1), F(n)]
    // показывает, что можно получить любое число Фибоначчи возведя матрицу One в степень N

    // используем алгоритм быстрого возведения в степень
    // https://ru.wikipedia.org/wiki/Алгоритмы_быстрого_возведения_в_степень
    // и BigInteger, чтобы большие числа получались
    // сложность алгоритма O (log n)


    public final static BigInteger[][] ONE = {{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};
    public static BigInteger[][] mul(BigInteger[][] a, BigInteger[][] b) {
        BigInteger[][] res = {
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))}
        };
        return res;
    }
    public static BigInteger[][] pow(BigInteger[][] a, int k) {

        if (k == 0) return ONE;
        if (k == 1) return a;
        if (k == 2) return mul(a, a);
        if (k % 2 == 1) return mul(ONE, pow(a, k - 1));
        return pow(pow(a, k / 2), 2);
    }

}
