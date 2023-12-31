package com.servlet.servlet2.corejava;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.*;
import java.util.stream.Stream;




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

        Collection<String> stringCollection = List.of("one", "two", "two", "three", "four", "five");
        Stream<String> strings0 = stringCollection.stream().distinct();
        Stream<String> strings = strings0.sorted();
        Stream<String> filteredStrings0 = strings.filter(s -> s.length()>2);
        Stream<String> filteredStrings = filteredStrings0.sorted();
        Stream<Integer> length = filteredStrings.map(String::length);
        System.out.println(length.toList());
        LinkedList<Integer>  intLinkedList =
                IntStream.range(0,10)
                        .boxed()
                        .sorted((a,b) -> a.compareTo(b*2))
                        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(intLinkedList);
    }

}
