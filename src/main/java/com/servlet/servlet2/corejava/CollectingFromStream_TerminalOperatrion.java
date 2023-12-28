package com.servlet.servlet2.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import  java.util.stream.Stream;

public class CollectingFromStream_TerminalOperatrion {
    public static void main(String[] args) {
        Stream<String> strings = Stream.of("one", "two", "three", "four");
        List<String>  result = new ArrayList<>();

        strings.filter(s->s.length() >3)
                .map(String::toUpperCase)
                .forEach(result::add); // not recommended

        System.out.println("result:: "+ result);
        Stream<String> strings2 = Stream.of("one", "two", "three", "four");
        result = strings2.filter(s -> s.length()==3)
                .map(String::toUpperCase)
                .collect(Collectors.toList()); // not recommended

        System.out.println("result:: "+ result);
        Stream<String> strings3 = Stream.of("one", "two", "three", "four");
        result = strings3.filter(s -> s.length()>=3)
                .map(String::toUpperCase)
                .toList();
        System.out.println("result:: "+ result);





    }
}
