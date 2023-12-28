package com.servlet.servlet2.corejava;
import java.util.stream.Stream;
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

        Stream<String> strings = Stream.of("one", "two", "three", "four");


        BinaryOperator<Integer> combiner = (length1, length2) -> length1 + length2;
        BiFunction<Integer, String, Integer> accumulator =
                (partialReduction, element) -> partialReduction + element.length();

        int result = strings.reduce(0,(a,b)-> {
            int x = a + b.length();
            System.out.println(a+">>"+b);
            return x;
        }, (c,d)-> {                      // why is this function is used?

        return -1;
        });
        System.out.println("sum = " + result);
    }
}
