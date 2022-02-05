package demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FourSumSolutionTest {
    @Test public void test1(){
        FourSumSolution target = new FourSumSolution();
        int[] nums = {1,0,-1,0,-2,2};
        int targetInt = 0;
        System.out.println(target.fourSum(nums, targetInt));
        List<List<Integer>> expect = new ArrayList<>();
        
        int[] testdata1 = {-2,-1,1,2};
        int[] testdata2 = {-2,0,0,2};
        int[] testdata3 = {-1,0,0,1};

        expect.add(makeTestDataList(testdata1));
        expect.add(makeTestDataList(testdata2));
        expect.add(makeTestDataList(testdata3));

        assertEquals(target.fourSum(nums, targetInt),expect);
    }

    @Test public void test2(){
        FourSumSolution target = new FourSumSolution();
        int[] nums = {2,2,2,2,2};
        int targetInt = 8;
        System.out.println(target.fourSum(nums, targetInt));
        List<List<Integer>> expect = new ArrayList<>();
        
        int[] testdata1 = {2,2,2,2};

        expect.add(makeTestDataList(testdata1));

        assertEquals(target.fourSum(nums, targetInt),expect);
    }

    private List<Integer> makeTestDataList(int[] testdata){

        List<Integer> retList = new ArrayList<>();

        for(int i : testdata){
            retList.add(i);
        }

        return retList;
    }
}
