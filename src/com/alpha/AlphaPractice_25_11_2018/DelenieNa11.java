package com.alpha.AlphaPractice_25_11_2018;

public class DelenieNa11 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (isSummKvadratov(ostatok(i))){ count++;
            System.out.println(i + " " + ostatok(i)); }
//            System.out.println(i + " " + ostatok(i));
        }

        System.out.println(count);
//        System.out.println(isSummKvadratov(14));
    }

    public static int ostatok(int n){
        return n%11;
    }

    public static boolean isSummKvadratov(int n){
        int count = n;
        int first = 0, second = 0, thrird = 0;
        for (int i = 1; i <= n; i++) {
            first = i*i;
            if ((first+second+thrird)==n && first!=0 && second!=0 && thrird!=0) return true;
            if (first<n){
                for (int j = 1; j <= n; j++) {
                    second = j*j;
                    if ((first+second+thrird)==n && first!=0 && second!=0 && thrird!=0) return true;
                    if ((first+second)<n){
                        for (int k = 1; k <= n; k++) {
                             thrird = k*k;
                             if ((first+second+thrird)==n) return true;
                             if ((first+second+thrird)>n) break;

                        }
                    }
                }

            }

        }
        return false;
    }
}
