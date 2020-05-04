package com.zochowski;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Abbreviations {

//    The word i18n is a common abbreviation of internationalization in the developer community, used instead of typing the whole word and trying to spell it correctly. Similarly, a11y is an abbreviation of accessibility.
//
//    Write a function that takes a string and turns any and all "words" (see below) within that string of length 4 or greater into an abbreviation, following these rules:
//
//    A "word" is a sequence of alphabetical characters. By this definition, any other character like a space or hyphen (eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
//    The abbreviated version of the word should have the first letter, then the number of removed characters, then the last letter (eg. "elephant ride" => "e6t r2e").


    //abbreviate("elephant-rides are really fun!")
//          ^^^^^^^^*^^^^^*^^^*^^^^^^*^^^*
// words (^):   "elephant" "rides" "are" "really" "fun"
//                123456     123     1     1234     1
// ignore short words:               X              X

// abbreviate:    "e6t"     "r3s"  "are"  "r4y"   "fun"
// all non-word characters (*) remain in place
//                     "-"      " "    " "     " "     "!"
    // "e6t-r3s are r4y fun!"

    public String abbreviate(String string) {
        String[] splittedString = string.split("[\\s|[^a-zA-Z]]");
        String stringWithoutDelimiters = Stream.of(splittedString)
                .map(this::convertString)
                .collect(Collectors.joining("*"));

        StringBuilder stringBuilder = new StringBuilder();
        int delimiterIndex = 0;
        for (int i = 0; i <stringWithoutDelimiters.length() ; i++) {
            String letter = String.valueOf(stringWithoutDelimiters.charAt(i));
            if (letter.matches("\\*")) {
                letter = getDelimitersInOrder(string).get(delimiterIndex);
                delimiterIndex++;
            }
            stringBuilder.append(letter);
        }
        if (delimiterIndex < getDelimitersInOrder(string).size()) {
            stringBuilder.append(getDelimitersInOrder(string).get(delimiterIndex));
        }
        return stringBuilder.toString();
    }

    private String convertString(String singleWord) {

        if (singleWord.length() < 4) {
            return singleWord;
        } else {
            return new String (
                     new StringBuilder().append(singleWord.charAt(0))
                    .append(singleWord.length()-2)
                    .append(singleWord.charAt(singleWord.length()-1))
            );
        }
    }

    private List<String> getDelimitersInOrder(String sentence) {
        List<String> delimiters = new LinkedList<>();
        for (int i = 0; i <sentence.length() ; i++) {
            char letter = sentence.charAt(i);
            if (String.valueOf(letter).matches("[\\s|[^a-zA-Z]]")) {
                delimiters.add(String.valueOf(letter));
            }
        }
        return delimiters;
    }
}
