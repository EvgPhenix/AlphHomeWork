package com.alpha;

//сумма двух чисел
//принимает значения от - Long.MIN_VALUE/2 до Long.MAX_VALU/2, если участвует float,
// то от - Long.MIN_VALUE/2 до Float.MAX_VALUE/2 (340,282,346,638,528,860,000,000,000,000,000,000,000,000.000000 в десятичной записи)
//числа задаются в String

public class HomeWork_30_09_2018 {

    public static void main(String[] args) {
        System.out.println(summ(Integer.toString(Integer.MIN_VALUE), Integer.toString(Integer.MIN_VALUE)));
        System.out.println(summ(Integer.toString(2147483647), Integer.toString(2147483647)));
        System.out.println(summ(Long.toString(Long.MAX_VALUE), Long.toString(Long.MAX_VALUE)));
        long x = Long.MAX_VALUE/2;
        long y = - Long.MIN_VALUE/2+1;
        System.out.println(summ(Long.toString(x), Long.toString(x)));
        System.out.println(summ(Long.toString(x), Long.toString(y)));
        float s = Float.MAX_VALUE/2;
        float d = Float.MIN_VALUE/2;
        System.out.println(summ(Float.toString(s), Float.toString(s)));
        System.out.println(summ(Float.toString(s), Float.toString(d)));
        System.out.println(summ(Long.toString(x), Float.toString(d)));
        System.out.println(summ(Float.toString(s), Long.toString(x)));

        System.out.println(summ("2", "3"));
        System.out.println(summ("2.555", "-11.138"));
        System.out.println(summ("12", "122.5"));
        System.out.println(summ("13600.500121", "626"));
    }

    public static String summ (String x, String y){
        System.out.println();
        System.out.println("x " + x);
        System.out.println("y " + y);
        if (!x.contains(".") && !y.contains(".")){
            try{
                long c1 = Long.parseLong(x);
                if (c1 < Long.MIN_VALUE/2 || c1 > Long.MAX_VALUE/2) return null;
                long c2 = Long.parseLong(y);
                if (c2 < Long.MIN_VALUE/2 || c2 > Long.MAX_VALUE/2) return null;
                return Long.toString(c1 + c2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (x.contains(".") && y.contains(".")){
            try{
                float c1 = Float.parseFloat(x);
                if (c1 < Float.MIN_VALUE/2 || c1 > Float.MAX_VALUE/2) return null;
                float c2 = Float.parseFloat(y);
                if (c2 < Float.MIN_VALUE/2 || c2 > Float.MAX_VALUE/2) return null;
                return Float.toString(c1 + c2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (x.contains(".") && !y.contains(".")){
            try{
                System.out.println((float) Math.round(Float.parseFloat(x)));
                if (Long.parseLong(y) < Long.MIN_VALUE/2 || Long.parseLong(y) > Long.MAX_VALUE/2) return null;
                String resPart1 = Float.toString((float)Math.round(Float.parseFloat(x)) + (float)Long.parseLong(y));
                return resPart1 + x.substring(x.indexOf ("."));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!x.contains(".") && y.contains(".")){
            try{
                if (Long.parseLong(x) < Long.MIN_VALUE/2 || Long.parseLong(x) > Long.MAX_VALUE/2) return null;
                String resPart1 = Float.toString(Long.parseLong(x) + Float.parseFloat(y));
                return resPart1 + y.substring(y.indexOf ("."));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
