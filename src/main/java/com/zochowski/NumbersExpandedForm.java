package com.zochowski;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersExpandedForm {

    public static String expandedForm (int num){
        if (num<= 0){
            return "Not a valid number";
        }

        String numberAsString = String.valueOf(num);
        char [] arr = numberAsString.toCharArray();
        System.out.println(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < arr.length ; i++) {
               int a = (int) (Character.getNumericValue(arr[i]) * Math.pow(10, arr.length - i- 1));
               if (a != 0) {
                   builder.append(a + " + ");
               }
        }
        builder.delete(builder.length()-3, builder.length());
        return builder.toString();
    }

    public static String bestSolutionToExpandedForm (int num)
    {
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? " + " + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;

        return outs;
    }

    public static String expandedFormUsingStreams (int num)
        {
            return IntStream.range(0, String.valueOf(num).length())
                    .mapToObj(x -> String.valueOf( Character.getNumericValue(String.valueOf(num).charAt(x) ) * (int)Math.pow(10, String.valueOf(num).substring(x).length()-1)))
                    .filter(x -> !x.equals("0"))
                    .collect(Collectors.joining(" + "));
        }
    }

