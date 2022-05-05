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

    @Test public void test2(){
        int n = -1;
        Integer strn = Integer.valueOf(n);
        String[] split = strn.toString().split("");
        System.out.println("n : "+ n);
        System.out.println("String n : "+ split[0]);

        String s = split[0] + split[1];
        System.out.println("String s : "+ Integer.valueOf(s));

        int ret = Integer.valueOf(s);
        System.out.println("ret : "+ ret);

    }
}
