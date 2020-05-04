package com.zochowski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbbreviationsTest {

    Abbreviations abbreviations = new Abbreviations();

    @Test
    @DisplayName("When provided a text with long words, those words should be abbreviated")
    public void whenTextHasLongWords_ThenWordsAreAbbreviated() {

        Assertions.assertEquals("J2n M3r", abbreviations.abbreviate("John Mayer"));
        Assertions.assertEquals("e6t-r3s are r4y fun!", abbreviations.abbreviate("elephant-rides are really fun!"));
    }
}
