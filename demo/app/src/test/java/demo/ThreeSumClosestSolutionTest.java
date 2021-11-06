package demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ThreeSumClosestSolutionTest {
    @Test public void test1(){
        ThreeSumClosestSolution target = new ThreeSumClosestSolution();
        int[] num = {-1,2,1,-4};
        int input = 1;
        System.out.println(target.threeSumClosest(num, input));
        
        int expect = 2;
      
        assertEquals(target.threeSumClosest(num, input),expect);
    }

    @Test public void test2(){
        ThreeSumClosestSolution target = new ThreeSumClosestSolution();
        int[] num = {1,1,1,0};
        int input = -100;
        System.out.println(target.threeSumClosest(num, input));
        
        int expect = 2;
      
        assertEquals(target.threeSumClosest(num, input),expect);
    }

    @Test public void test3(){
        ThreeSumClosestSolution target = new ThreeSumClosestSolution();
        int[] num = {1,1,-1,-1,3};
        int input = -1;
        System.out.println(target.threeSumClosest(num, input));
        
        int expect = -1;
      
        assertEquals(target.threeSumClosest(num, input),expect);
    }

}
