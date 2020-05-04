package com.zochowski;


public class TriplesAndDoubles {

    public static int TripleDouble(long num1, long num2)
    {
        String string1 = String.valueOf(num1);
        String string2 = String.valueOf(num2);
        char [] arr1 = string1.toCharArray();
        char [] arr2 = string2.toCharArray();
        int sameDigitInArray1 = 0;
        int sameDigitInArray2 = 0;
        for (int i = 0; i <arr1.length ; i++) {

            if (i+2 < arr1.length && arr1[i] == arr1[i+1] && arr1[i+1] == arr1[i+2]){
                sameDigitInArray1++;
            }
        }

        for (int i = 0; i <arr2.length ; i++) {
            if (i+2 < arr2.length){
                break;
            }
            if (i+2 < arr2.length && arr2[i] == arr2[i+1] && arr2[i+1] == arr2[i+2]){
                sameDigitInArray2++;
            }
        }

        if (sameDigitInArray1 == 3 && sameDigitInArray2 == 2){
            return 1;
        } else return 0;
    }
}
