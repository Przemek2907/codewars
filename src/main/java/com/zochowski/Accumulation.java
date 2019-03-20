package com.zochowski;


import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Accumulation {

    public static String accum(String s) {

        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String temp = Character.toUpperCase(arr[i]) + String.join("", Collections.nCopies(i, String.valueOf(Character.toLowerCase(arr[i]))));
            System.out.println(temp);
            builder.append(temp + "-");
        }
        return builder.deleteCharAt(builder.lastIndexOf("-")).toString();
    }

    public static String accum2(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(i -> IntStream.range(0, i + 1)
                        .mapToObj(i1 -> i1 == 0 ? String.valueOf(s.charAt(i)).toUpperCase() : String.valueOf(s.charAt(i)).toLowerCase())
                        .collect(Collectors.joining())
                ).collect(Collectors.joining("-"));
    }

    public static String accum3(String s) {
        return IntStream.range(0,s.length())
                .mapToObj(i->Stream.generate(()->s.charAt(i)).limit(i+1).collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString())
                .map(a->a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase())
                .collect(Collectors.joining("-"));
    }

    public static String accum4(String s) {
        StringBuilder bldr = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()) {
            if(i > 0) bldr.append('-');
            bldr.append(Character.toUpperCase(c));
            for(int j = 0; j < i; j++) bldr.append(Character.toLowerCase(c));
            i++;
        }
        return bldr.toString();
    }
}
