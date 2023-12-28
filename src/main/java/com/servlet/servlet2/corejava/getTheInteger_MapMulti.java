package com.servlet.servlet2.corejava;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.mysql.cj.conf.PropertyKey.logger;

public  class getTheInteger_MapMulti {

    static Function<Integer,Integer>  incrementByOne = number -> number+1;
    static Function<Integer,Integer> multiplyBy10 = number -> number*10;
    public static void main(String[] args) {
        Function<String , Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            }
            catch (NumberFormatException ignore){

            }
            return Stream.empty();
        };

        List<String> strings = List.of("22", "22", "22", "13", "1", "6","4", "1", "23", "6", "", "7");

        List<Integer> ints ;

//
//        ints = strings.stream()
//                      .<Integer>mapMulti((stringToParser, consumer)->{
//                          try {
//                                consumer.accept(Integer.parseInt(stringToParser));
//                          }catch (NumberFormatException ignored){
//
//                        }
//                    }).sorted()
//                      .skip(1)
//                      .limit(5)
//                      .collect(Collectors.toList());

        System.out.println(strings);
        ints = strings.stream()
                .<Integer>mapMulti((stringToParser, consumer)->{
                    try {
                        consumer.accept(Integer.parseInt(stringToParser));
                    }catch (NumberFormatException ignored){

                    }
                })
                .takeWhile(integer -> integer>=1)
                .peek(s-> System.out.println("showing the taken data: "+ s))
                .dropWhile(integer -> integer>10)
                .peek(s->{System.out.println("showing the dropped data: "+ s);})
                .collect(Collectors.toList());
        // take while >> takes elements from the stream while the specified predicate is true.
        //              Once the predicate becomes false, it stops including elements in the stream.
        // do while>> skips elements in the stream until the specified predicate becomes false.
        //              Once the predicate becomes false, it includes the remaining elements in the stream.

//        System.out.println(ints);

        int x = incrementByOne.apply(2);
        System.out.println("x  :: " + x);
        Function<Integer,Integer> then = incrementByOne.andThen(multiplyBy10);
        int y = then.apply( 10);
        System.out.println("y:: "+y);
        int z = incrementByOne.compose(multiplyBy10).apply(2); // here the multiplication will happen first and then the increment will take place ...
        System.out.println("z:: "+z);


        HashMap<Integer, String> mp = new HashMap<>();

        mp.put( 1,"irfan");
        mp.put(2,"shamim");
        mp.put(3,"projnajit");

        mp.keySet().stream().peek(s-> System.out.println("peaking at ::" + s)).forEach(key-> System.out.println("the valule of the key:: "+ key +" is :: "+mp.get(key)));

        Stream<String> generate = Stream.generate(()-> "+");
        List<String> string  = generate.limit(10L).collect(Collectors.toList());

        System.out.println(string);

    }
}
