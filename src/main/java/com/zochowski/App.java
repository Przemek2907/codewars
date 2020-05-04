package com.zochowski;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        String result = com.zochowski.NumbersExpandedForm.expandedForm(70304);
        System.out.println(result);
        int quareDigits = SquareDigits.squareDigits(9119);
        System.out.println(quareDigits);

        String test = Accumulation.accum("RqaEzty");
        System.out.println(test);
    }
}
