package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RomantoIntegerSolutionTest {
    @Test public void test1(){
        RomantoIntegerSolution target = new RomantoIntegerSolution();
        String num = "III";
        System.out.println(target.romanToInt(num));
        assertTrue(target.romanToInt(num) == 3);
    }

    @Test public void test2(){
        RomantoIntegerSolution target = new RomantoIntegerSolution();
        String num = "MCMXCIV";
        System.out.println(target.romanToInt(num));
        assertTrue(target.romanToInt(num) == 1994);
    }
}
