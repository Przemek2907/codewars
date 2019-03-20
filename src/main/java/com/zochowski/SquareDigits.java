package com.zochowski;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareDigits {

    public static int squareDigits(int n) {
        String numberAsString = String.valueOf(n);
        char[] arr = numberAsString.toCharArray();
        System.out.println(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int a = (int) Math.pow(Character.getNumericValue(arr[i]), 2);
            builder.append(a);
        }
        return Integer.parseInt(builder.toString());
    }

    public static int streamsSquareDigits (int n){
            return Integer.parseInt(String.valueOf(n)
                    .chars()
                    .map(i -> Integer.parseInt(String.valueOf((char) i)))
                    .map(i -> i * i)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("")));
        }
    }

