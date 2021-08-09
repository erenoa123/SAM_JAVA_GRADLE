package demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegertoRomanSolutionTest {
    @Test public void test1(){
        IntegertoRomanSolution target = new IntegertoRomanSolution();
        int num = 1994;
        System.out.println(target.intToRoman(num));
        assertTrue("MCMXCIV".equals(target.intToRoman(num)));
    }

    @Test public void test2(){
        IntegertoRomanSolution target = new IntegertoRomanSolution();
        int num = 58;
        System.out.println(target.intToRoman(num));
        assertTrue("LVIII".equals(target.intToRoman(num)));
    }
}
