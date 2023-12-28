package com.servlet.servlet2.corejava;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BiFunctionVSbinaryOPPerator {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> checkIfChild = (a, b) -> {
            if (a + b > 20)
                return "OK";
            else return "NOT OK";
        };
        System.out.println(checkIfChild.apply(2,12));
        System.out.println(checkIfChild.apply(12,12));

        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(22,22));
    }
}
