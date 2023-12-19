package com.servlet.servlet2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
class func2 implements func{

    @Override
    public void fun() {
        System.out.println("jah implement korlam.");
    }
}
public class FuncInterface {

    public static void main(String[] args) {



        func ff =  () ->System.out.println("its as functional interface ");
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Stream<Integer> strm = list.stream().filter(n-> n<4);
//        strm.forEach(System.out::println);
        System.out.println(strm.reduce(3,(c,e)->{ // here in ter initial the c value is assigned with the identity value given in the first perametre
            System.out.println(c +" "+ e);
            return c+e;
        } ));// here will give error . stream can only be used once.
        ff.fun();
    }
}
