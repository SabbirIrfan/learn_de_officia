package com.servlet.servlet2.corejava;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;


public class Date_Time {

    public static void main(String[] args) {


        LocalDate today = LocalDate.now();
        LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println(today);


    }
}
