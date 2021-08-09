package demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContainerWithMostWaterSolutionTest {
    @Test public void test1(){
        ContainerWithMostWaterSolution target = new ContainerWithMostWaterSolution();
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(target.maxArea(height));
        assertTrue(target.maxArea(height) == 49);
    }

    @Test public void test2(){
        ContainerWithMostWaterSolution target = new ContainerWithMostWaterSolution();
        int [] height = {1,2,4,3};
        System.out.println(target.maxArea(height));
        assertTrue(target.maxArea(height) == 4);
    }

}
