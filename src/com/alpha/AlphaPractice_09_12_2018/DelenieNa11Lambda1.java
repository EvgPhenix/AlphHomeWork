package com.alpha.AlphaPractice_09_12_2018;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DelenieNa11Lambda1 {
    public static void main(String[] args) {
        IntStream.range(12, 1000)
                .filter(value -> Stream.iterate(value, i -> i > 0, i -> i/10)
                        .map(x -> (x%10)*(x%10))
                        .reduce(0, (a, b) -> a + b) == value % 11)
                .forEach(System.out::println);
    }
}
