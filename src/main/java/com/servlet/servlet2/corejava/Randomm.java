package com.servlet.servlet2.corejava;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;



class how {
    @Override
    public String toString() {

        return "hello you have just called the ohject";
    }
}
public class Randomm {
    public static void main(String[] args) {

        how h = new how();

        System.out.println(h);

//        Random random = new Random(314L);
//        List<String> letters =
//                random.doubles(1_000, 0d, 1d)
//                        .mapToObj(rand ->
//                                 rand < 0.5 ? "A" : rand < 0.8 ? "B" : rand < 0.9 ? "C" : "D").collect(Collectors.toList());
//
//        Map<String, Long> map =
//                letters.stream()
//                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        map.forEach((letter, number) -> System.out.println(letter + " :: " + number));

    }

}
