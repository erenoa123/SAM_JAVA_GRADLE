package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NextPermutationTest {
    @Test public void test1(){
        Solution target = new Solution();
        int[] nums = {3,2,1};
        int[] expnums = {1,2,3};
        target.nextPermutation(nums);
        
        assertTrue(check(nums, expnums));
    }

    @Test public void test2(){
        Solution target = new Solution();
        int[] nums = {2,3,1};
        int[] expnums = {3,1,2};
        target.nextPermutation(nums);
        
        assertTrue(check(nums, expnums));
    }

    private boolean check(int[] nums, int[] expnums){

        if(nums.length != expnums.length){
            return false;
        }

        for(int i= 0 ; i < nums.length; i++){
            System.out.println(nums[i]+" ");
            if ( nums[i] != expnums[i]){
                return false;
            }
        }

        return true;

    }
}
