package com.servlet.servlet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import static java.util.stream.Collectors.*;

@FunctionalInterface
interface  func{
//    default void meth(){
//        System.out.println("this is a default method of interface ");
//
//    }
//    default int meth2(){
//        System.out.println("can i declare two default method>?");
//        return 22;
//    }
    public  void fun();

}
class user{
    public int age;
    public user(int x){
        this.age = x;
    }

    public int getAge() {
        return age;
    }
}
class func2 implements func{


    @Override
    public void fun() {
        System.out.println("jah implement korlam.");
    }

    public static void groupByMethod(){
        List<String> strings = List.of("one","two","three","four");
//        System.out.println(strings.stream().map(s -> s.length()).filter());

        List<Integer> list = strings.stream().map(String::length).toList();
        Stream<String> st = strings.stream();
        Stream<Integer>  nst = st.map(String::length);
        System.out.println(nst.toList());

        System.out.println(list);
        var map = strings.stream()
                .collect(groupingByConcurrent(String::length, counting()));
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

    }
}
public class FuncInterface {


    public static void main(String[] args) {
        user u0 = new user(1);
        user u1 = new user(2);
        user u2 = new user(2);
        user u3 = new user(4);
        List<user> list = new ArrayList<>();
        list.add(u0);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        func2.groupByMethod();
        int sum = list.stream().map(user::getAge).filter(age-> age>1).reduce(0, Integer::sum);
        System.out.println(sum);




//        func ff =  () ->System.out.println("its as functional interface ");
//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//
//        Stream<Integer> strm = list.stream().filter(n-> n<4);
////        strm.forEach(System.out::println);
//        System.out.println(strm.reduce(3,(c,e)->{ // here in ter initial the c value is assigned with the identity value given in the first perametre
//            System.out.println(c +" "+ e);
//            return c+e;
//        } ));// here will give error . stream can only be used once.
//        ff.fun();
    }
}
