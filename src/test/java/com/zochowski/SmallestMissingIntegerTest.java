package com.zochowski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SmallestMissingIntegerTest {

    SmallestMissingInteger smallestMissingInteger = new SmallestMissingInteger();

    @Test
    @DisplayName(" Given A = [1, 2, 3], the function should return 4.")
    public void smallestIntegerOutsideTheArrayScope() {
        Assertions.assertEquals(4, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{1,2,3}));
    }

    @Test
    @DisplayName("Given A = [−1, −3], the function should return 1")
    public void smallestPositiveNumber() {
        Assertions.assertEquals(1, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{-1,-3}));
    }

    @Test
    @DisplayName("Given A = [1, 3, 6, 4, 1, 2], the function should return 5")
    public void missingPositiveNumberInArray() {
        Assertions.assertEquals(5, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{1, 3, 6, 4, 1, 2}));
    }

    @Test
    @DisplayName("Given large unsorted set of numbers with multiple gaps, should return 30 678, the function should return 5")
    public void largeSetOfNumbersEfficiency() {
        int[] largeArray = new int[4567890];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = largeArray.length - i;
        }
        largeArray[30678] = -3;
        Assertions.assertEquals(4567890 - 30678, smallestMissingInteger.findSmallestPositiveIntegerFromArray(largeArray));
    }

    @Test
    @DisplayName("More tests")
    public void moreTests() {
        Assertions.assertEquals(1, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{-1, 3, -6, 0, 7, 2}));
        Assertions.assertEquals(2, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{0,1,0,1,0,30,1}));
        Assertions.assertEquals(1, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{235670, 34521, 56788, 34000, 45111,}));
        Assertions.assertEquals(1, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{-1,-1,-2,0,0,0}));
        Assertions.assertEquals(1, smallestMissingInteger.findSmallestPositiveIntegerFromArray(new int[]{999999, 1000000}));
    }
}
