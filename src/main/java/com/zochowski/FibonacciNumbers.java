package com.zochowski;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbers {

    public static long[] productFib(long prod) {

        long absProd = Math.abs(prod);

        System.out.println("--->" + prod);

        if (prod == 0) {
            return new long[]{0, 1, 0};
        } else if (prod ==1) {
            return new long[]{1, 1, 1};
        }

            List<Long> fibonacciArr = generateFibonacciArray(absProd/4);


            for (int i = 0; i < fibonacciArr.size() - 1; i++) {
                if (fibonacciArr.get(i) * fibonacciArr.get(i + 1) == absProd) {
                    return new long[]{fibonacciArr.get(i) , fibonacciArr.get(i + 1), 1};
                } else if (fibonacciArr.get(i) * fibonacciArr.get(i + 1) > absProd) {
                    return new long[]{fibonacciArr.get(i) , fibonacciArr.get(i + 1), 0};
                }
            }
        return null;
    }

    private static List<Long> generateFibonacciArray(long prod) {
        List<Long> fibonacciArr = new ArrayList<>();
       fibonacciArr.add(0, 0L);
       fibonacciArr.add(1, 1L);

        for (int i = 2; i < prod ; i++) {
            fibonacciArr.add(i, fibonacciArr.get(i-1) + fibonacciArr.get(i-2));
        }

        return fibonacciArr;
    }

    // better solutions found on codewars
    // this one is more clever as it uses the while loop to self increment the multiplicands

    public static long[] productFib2(long prod) {
        long a = 0L;
        long b = 1L;
        while (a * b < prod) {
            long tmp = a;
            a = b;
            b = tmp + b;
        }
        return new long[] { a, b, a * b == prod ? 1 : 0 };
    }
}
