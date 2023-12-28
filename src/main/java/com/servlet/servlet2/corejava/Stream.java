package com.servlet.servlet2.corejava;

import java.util.ArrayList;
import java.util.List;


 class State{
    String name;
     List<City> cities = new ArrayList<>();



     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public List<City> getCities() {
         return cities;
     }

     public void setCities(List<City> cities) {
         this.cities = cities;
     }

}


  class City{
    String name;
      List<Town> towns = new ArrayList<>();

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public List<Town> getTowns() {
          return towns;
      }

      public void setTowns(List<Town> towns) {
          this.towns = towns;
      }


}


 class Town{
    String name;
     int Population;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getPopulation() {
         return Population;
     }

     public void setPopulation(int population) {
         Population = population;
     }


}


public class Stream {
    public static void main(String[] args) {

        State st1 = new State();
        City c1st1 = new City();
        City c2st1 = new City();

        Town c1st1t1 = new Town();
        Town c1st1t2 = new Town();
        c1st1t1.setPopulation(111);
        c1st1t2.setPopulation(111);

        Town c2st1t1 = new Town();
        Town c2st1t2 = new Town();
        c2st1t1.setPopulation(111);
        c2st1t2.setPopulation(111);

        c1st1.towns.add(c1st1t1);
        c1st1.towns.add(c1st1t2);


        st1.cities.add(c1st1);
        st1.cities.add(c2st1);

        c2st1.towns.add(c2st1t1);
        c2st1.towns.add(c2st1t2);


        State st2 = new State();




        City c1st2 = new City();
        City c2st2 = new City();


        Town c1st2t1 = new Town();
        Town c1st2t2 = new Town();
        c1st2t1.setPopulation(111);
        c1st2t2.setPopulation(111);
        c1st2.towns.add(c1st2t1);
        c1st2.towns.add(c1st2t2);


        Town c2st2t1 = new Town();
        Town c2st2t2 = new Town();
        c2st2t1.setPopulation(111);
        c2st2t2.setPopulation(111);
        c1st2.towns.add(c2st2t1);
        c1st2.towns.add(c2st2t2);
        List<State> states = new ArrayList<>();
        states.add(st1);
        states.add(st2);

        int totalPopulation = states.stream()
                                    .flatMap(state -> state.getCities().stream())
                                    .flatMap(city -> city.getTowns().stream())
                                    .mapToInt(Town::getPopulation)
                                    .sum();


        System.out.println(totalPopulation);


        List<String> strings = List.of("1"," ","2","2" , "3", "4","7"," 6","5");

        List<Integer> ints = strings.stream().<Integer> mapMulti((str, Consumer) ->{
            try {
                Consumer.accept(Integer.parseInt(str));
            }
            catch (NumberFormatException ignore){

            }
        }).toList();
        System.out.println(ints);

        ints = ints.stream().distinct().toList();
        ints = ints.stream().sorted().toList();
        System.out.println(ints);

    }


}
