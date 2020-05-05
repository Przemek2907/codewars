package com.zochowski;


public class NumbersTransformer {

    public static long nextBiggerNumber(long n) {

        char[] numberAsCharArr = Long.toString(n).toCharArray();

        for (int i = 0; i < numberAsCharArr.length - 1; i++) {
            //it will be processed from the end
            char firstLetter = numberAsCharArr[numberAsCharArr.length - 1 - i];
            char secondLetter = numberAsCharArr[numberAsCharArr.length- 1 - (i+1)];
            if (Long.parseLong(String.valueOf(firstLetter)) > Long.parseLong(String.valueOf(secondLetter))) {
                numberAsCharArr[numberAsCharArr.length - 1 - i] = secondLetter;
                numberAsCharArr[numberAsCharArr.length- 1 - (i+1)] = firstLetter;
                break;
            }
        }


        return Long.parseLong(String.valueOf(numberAsCharArr)) == n ? -1 : Long.parseLong(String.valueOf(numberAsCharArr));
    }
}

