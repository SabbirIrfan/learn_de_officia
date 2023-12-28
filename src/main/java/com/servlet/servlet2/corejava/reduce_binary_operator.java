package com.servlet.servlet2.corejava;

import java.util.List;
import java.util.function.BinaryOperator;

public class reduce_binary_operator {

    public static void main(String[] args) {
        List<Integer> ints = List.of(1,6,3,5,11,4,5);

        BinaryOperator<Integer> max = (a,b) -> a>b?a:b;
//        int res  = ints.get(0);
//        int mx = res,mx2=0;
//        for(int i = 1; i<ints.size(); i++){
//
//            res = ints.get(i);
//            if(res>mx){
//                mx2 = mx;
//
//                mx = res;
//                System.out.println(mx+"<mx mx2>>"+mx2+ " "+res);
//                }
//            else if(res>mx2){
//                    mx2 = res;
//            }
//
//        }
//
//        System.out.println(mx2);

    }
}
