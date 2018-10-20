package com.alpha;

// Метод generateMassive генерирует одномерные массивы длиной до 256 исмволов из
// int-ов, коорые затем превращаются в String
// Метод spiral(String[] mass) проверяет, возможно ли получить квадратный корень из длины
// масссива, который будет целым числом, если да то размещает их по спирали и для проверки
// еще размещает по спирали числа от одного до длины такого же массива

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


public class HomeWork_14_10_2018 {

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

        for (int i = 0; i < 100; i++) {
            spiral(generateMassive());
        }
        spiral(generateMassive());
    }

    public static void spiral(String[] mass){
        double z = Math.sqrt((double)mass.length);
        String x = Double.toString(z);
        if (!(x.substring(x.indexOf(".")+1, x.length()-1).matches("[0-9]+"))){
            int n = (int)Math.sqrt((double)mass.length);
            String[][] matrix = new String[n][n];
            String[][] matr123 = new String[n][n];

            int row = 0;
            int col = 0;
            int dx = 1;
            int dy = 0;
            int dirChanges = 0;
            int visits = n;

            for (int i = 0; i < n * n; i++) {
                matrix[row][col] = mass[i];
                matr123[row][col] = Integer.toString(i+1);
                if (--visits == 0) {
                    visits = n * (dirChanges % 2) +
                            n * ((dirChanges + 1) % 2) -
                            (dirChanges / 2 - 1) - 2;
                    int temp = dx;
                    dx = -dy;
                    dy = temp;
                    dirChanges++;
                }
                col += dx;
                row += dy;
            }

            System.out.println("!!!!_______________________________________________________");
            System.out.println("Этот массив подходит, т.к. его квадратный корень целое число");
            System.out.println("Длина массива равна " + mass.length);
            System.out.println("Квадратный корень этой длины равен " + Math.sqrt(mass.length));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(matrix[i][j] + "\t");
                System.out.println();
            }
            System.out.println("______________________________________________");
            System.out.println();



            System.out.println("!!!!_______________________________________________________");
            System.out.println("Проверки ради заполним этот же массив числами от 1 до его длины");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(matr123[i][j] + "\t");
                System.out.println();
            }
            System.out.println("______________________________________________");
            System.out.println();

        } else {
            System.out.println("Этот массив не подходит, т.к. его квадратный корень не целое число");
            System.out.println("Длина массива равна " + mass.length);
            System.out.println("Квадратный корень этой длины равен " + Math.sqrt(mass.length));
            for (int i = 0; i < mass.length; i++) {
                System.out.print(mass[i] + " ");
            }
            System.out.println();
        }

    }
}
