package com.alpha;

// Метод generateMassive генерирует одномерные массивы длиной до 256 исмволов из
// int-ов, коорые затем превращаются в String
// Метод spiral(String[] mass) проверяет c помощью метода matches(String[] mass), возможно ли получить квадратный корень из длины
// масссива, который будет целым числом, если да то размещает их по спирали и для проверки
// еще размещает по спирали числа от одного до длины такого же массива
// остальные методы для вывода

// Проверил следующие библиотеки, работающие с матрицами в Java
//        Apache Commons Math: http://commons.apache.org/proper/commons-math/
//        jeigen - обертка для собственного - https://github.com/hughperkins/jeigen (включает сложную и редко найденную функцию,
//                 такую ​​как экспоненциальный матричный и матричный логарифм)
//        jblas http://mikiobraun.github.io/jblas/ (также имеет более сложные функции, такие как экспоненциальная матрица, также очень быстро).
//        Colt http://acs.lbl.gov/software/colt/
//        JAMA http://math.nist.gov/javanumerics/jama/
//        UJMP - http://sourceforge.net/projects/ujmp/
//        ojAlgo - http://ojalgo.org/ имеет многообещающие тесты
//        Эффективная библиотека матриц Java (EJML) - http://ejml.org
//        ParallelColt - https://sites.google.com/site/piotrwendykier/software/parallelcolt
//        la4j - http://la4j.org/
//        MTJ - https://github.com/fommil/matrix-toolkits-java
//        nd4j - https://nd4j.org/ позволяет выбирать основные встроенные реализации, такие как cuda или openBlas

//  Нигде необхлжимого функционала не нашел


public class HomeWork_14_10_2018_SpiralMatrix {

    public static String[] generateMassive(){
        int massiveLength = 0 + (int) (Math.random() * 256);
        String[] mass = new String[massiveLength];
        for (int i = 0; i < mass.length; i++) {
            String s = Integer.toString(0 + (int) (Math.random() * 121));
            mass[i] = s;
        }
        return mass;
    }

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(16));
//        int[] mass = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//        int[] mass = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//        String[] mass = {"decdec", "11", "3", "4", "5", "177", "6", "8", "9"};

//        int massiveLength = 0 + (int) (Math.random() * 256);
//        String[] mass = new String[massiveLength];
//        for (int i = 0; i < mass.length; i++) {
//            String s = Integer.toString(0 + (int) (Math.random() * 256));
//            mass[i] = s;
//        }

//        String x = Double.toString(Math.sqrt((double)mass.length));
//        System.out.println(x);
//        System.out.println(x.substring(x.indexOf(".")+1, x.length()-1));
//        boolean b =x.substring(x.indexOf(".")+1, x.length()-1).matches("[0-9]+");
//        System.out.println(b);
        for (int i = 0; i < 100; i++) {
            spiral(generateMassive());
        }
        spiral(generateMassive());
    }

    public static void spiral(String[] mass){
//        double z = Math.sqrt((double)mass.length);
//        String x = Double.toString(z);
//        if (!(x.substring(x.indexOf(".")+1, x.length()-1).matches("[0-9]+"))){
        if (!matches(mass)){
            int n = (int)Math.sqrt((double)mass.length);
            String[][] matrix = new String[n][n];
            String[][] matr123 = new String[n][n];

            int row = 0, col = 0, dx = 1, dy = 0, dirChanges = 0, visits = n;

            for (int i = 0; i < n * n; i++) {
                matrix[row][col] = mass[i];
                matr123[row][col] = Integer.toString(i+1);
                if (--visits == 0) {
                    visits = n * (dirChanges % 2) + n * ((dirChanges + 1) % 2) - (dirChanges / 2 - 1) - 2;
                    int temp = dx;
                    dx = -dy;
                    dy = temp;
                    dirChanges++;
                }
                col += dx;
                row += dy;
            }
            vivodGood(matrix, n);
            goodVivod2(matr123, n);

        } else {
            badVivod(mass);
        }

    }

    public static void vivodGood(String[][] mass, int n){
        System.out.println("!!!!_______________________________________________________");
        System.out.println("Этот массив подходит, т.к. его квадратный корень целое число");
        System.out.println("Длина массива равна " + mass.length);
        System.out.println("Квадратный корень этой длины равен " + Math.sqrt(mass.length));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mass[i][j] + "\t");
            System.out.println();
        }
        System.out.println("______________________________________________");
        System.out.println();
    }

    public static void goodVivod2(String[][] mass, int n){
        System.out.println("!!!!_______________________________________________________");
        System.out.println("Проверки ради заполним этот же массив числами от 1 до его длины");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mass[i][j] + "\t");
            System.out.println();
        }
        System.out.println("______________________________________________");
        System.out.println();
    }

    public static void badVivod(String[] mass){
        System.out.println("Этот массив не подходит, т.к. его квадратный корень не целое число");
        System.out.println("Длина массива равна " + mass.length);
        System.out.println("Квадратный корень этой длины равен " + Math.sqrt(mass.length));
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }

    public static boolean matches(String[] mass){
        double z = Math.sqrt((double)mass.length);
        String x = Double.toString(z);
        return x.substring(x.indexOf(".")+1, x.length()-1).matches("[0-9]+");
    }
}
