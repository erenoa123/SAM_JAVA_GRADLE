package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DivideTwoIntegersSolutionTest {
    @Test
    public void test1() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = 10;
        int divis = 3;
        assertTrue(target.divide(divid, divis) == 3);
    }

    @Test
    public void test2() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = -10;
        int divis = 3;
        assertTrue(target.divide(divid, divis) == -3);
    }

    @Test
    public void test3() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = 10;
        int divis = -3;
        assertTrue(target.divide(divid, divis) == -3);
    }

    @Test
    public void test4() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = 21567893;
        int divis = 3;
        System.out.println(target.divide(divid, divis));
        assertTrue(target.divide(divid, divis) == 7189297);
    }

    @Test
    public void test5() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = 21567893;
        int divis = 33;
        System.out.println(target.divide(divid, divis));
        assertTrue(target.divide(divid, divis) == divid / divis);
    }

    @Test
    public void test6() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = 1;
        int divis = 2;
        System.out.println(target.divide(divid, divis));
        assertTrue(target.divide(divid, divis) == divid / divis);
    }

    @Test
    public void test7() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = Integer.MIN_VALUE;
        int divis = -1;
        System.out.println(target.divide(divid, divis));
        assertTrue(target.divide(divid, divis) == Integer.MAX_VALUE);
    }

    @Test
    public void test8() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = 2147483647;
        int divis = 2;
        System.out.println(target.divide(divid, divis));
        assertTrue(target.divide(divid, divis) == divid / divis);
    }

    @Test
    public void test9() {
        DivideTwoIntegersSolution target = new DivideTwoIntegersSolution();
        int divid = -2147483648;
        int divis = -1017100424;
        System.out.println(target.divide(divid, divis));
        assertTrue(target.divide(divid, divis) == divid / divis);
    }
}
