package com.servlet.servlet2.corejava;

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
class user<T>{
    public int age;

    public <T extends   Number > void findMax(List<T> list) {
        // method implementation
        list.forEach(System.out::println);
        
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

        user<Integer> u = new user<>();

        u.findMax(List.of(1,2,3));

//        user u0 = new user(1);
//        user u1 = new user(2);
//        user u2 = new user(2);
//        user u3 = new user(4);
//        List<user> list = new ArrayList<>();
//        list.add(u0);
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
//        func2.groupByMethod();
//        int sum = list.stream().map(user::getAge).filter(age-> age>1).reduce(0, Integer::sum);
//        System.out.println(sum);




    }
}
