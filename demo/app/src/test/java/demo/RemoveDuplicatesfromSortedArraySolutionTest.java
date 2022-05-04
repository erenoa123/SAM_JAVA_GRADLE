package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArraySolutionTest {
    @Test public void test1(){
        RemoveDuplicatesfromSortedArraySolution target = new RemoveDuplicatesfromSortedArraySolution();
        int [] nums = {1,1,2,2,3,3,4,5,5};
        assertTrue(target.removeDuplicates(nums) == 5);
        for(Integer n : nums){
            System.out.println("n : "+ n);
        }
    }
}
