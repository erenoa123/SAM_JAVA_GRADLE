package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SwapNodesinPairsSolutionTest {
    @Test public void test1(){
        SwapNodesinPairsSolution target = new SwapNodesinPairsSolution();
        int[] nums = {1,2,3,4};
        ListNode testdata = ListNodeUtils.make(nums);
        int[] expnums = {2,1,4,3};

        ListNode exp = ListNodeUtils.make(expnums);
        
        ListNode val = target.swapPairs(testdata);

        assertTrue(ListNodeUtils.assertListNode(val, exp));
    }
}
