package com.zochowski;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestMissingInteger {

    /*
    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].
     */

    public Integer findSmallestPositiveIntegerFromArray(int[] A) {
        List<Integer> sortedListOfIntegers = Arrays.stream(A).sorted()
                .boxed()
                .filter(x -> x >=0)
                .collect(Collectors.toList());

        if (sortedListOfIntegers.size() == 0 || sortedListOfIntegers.get(sortedListOfIntegers.size()-1) <= 0 || sortedListOfIntegers.get(0) > 1) {
            return 1;
        }


        int result = 1;
        for (int i = 0; i < sortedListOfIntegers.size() - 1; i++) {
            if (sortedListOfIntegers.get(i+1) - sortedListOfIntegers.get(i) > 1) {
                result = sortedListOfIntegers.get(i) + 1;
                break;
            } else {
                result = sortedListOfIntegers.get(sortedListOfIntegers.size()-1) + 1;
            }
        }

        return result;
    }
}
