package demo;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ThreeSumSolutionTest {
    @Test public void test1(){
        ThreeSumSolution target = new ThreeSumSolution();
        int[] num = {-1,0,1,2,-1,-4};
        System.out.println(target.threeSum(num));
        List<List<Integer>> expect = new ArrayList<>();
        
        int[] testdata1 = {-1,-1,2};
        int[] testdata2 = {-1,0,1};

        expect.add(makeTestDataList(testdata1));
        expect.add(makeTestDataList(testdata2));

        

        assertEquals(target.threeSum(num),expect);
    }

    private List<Integer> makeTestDataList(int[] testdata){

        List<Integer> retList = new ArrayList<>();

        for(int i : testdata){
            retList.add(i);
        }

        return retList;
    }
}
