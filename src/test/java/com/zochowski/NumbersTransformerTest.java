package com.zochowski;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTransformerTest {

    @Test
    @DisplayName("Basic tests")
    public void basicTests() {
        assertEquals(21, NumbersTransformer.nextBiggerNumber(12));
        assertEquals(531, NumbersTransformer.nextBiggerNumber(513));
        assertEquals(2071, NumbersTransformer.nextBiggerNumber(2017));
        assertEquals(441, NumbersTransformer.nextBiggerNumber(414));
        assertEquals(414, NumbersTransformer.nextBiggerNumber(144));
    }

    @Test
    @DisplayName("Advanced tests")
    public void advancedTests() {
        assertEquals(1234567908, NumbersTransformer.nextBiggerNumber(1234567890));
        assertEquals(2038209169, NumbersTransformer.nextBiggerNumber(2038209619));
    }
}
