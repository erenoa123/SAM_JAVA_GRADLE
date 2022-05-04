package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReverseNodesinkGroupSolutionTest {
    @Test public void test1(){
        ReverseNodesinkGroupSolution target = new ReverseNodesinkGroupSolution();
        int[] nums = {1,2,3,4,5};
        ListNode testdata = ListNodeUtils.make(nums);
        int[] expnums = {2,1,4,3,5};

        ListNode exp = ListNodeUtils.make(expnums);
        
        ListNode val = target.reverseKGroup(testdata,2);
        ListNodeUtils.print(val);

        assertTrue(ListNodeUtils.assertListNode(val, exp));
    }

    @Test public void test2(){
        ReverseNodesinkGroupSolution target = new ReverseNodesinkGroupSolution();
        int[] nums = {1,2,3,4,5};
        ListNode testdata = ListNodeUtils.make(nums);
        int[] expnums = {3,2,1,4,5};

        ListNode exp = ListNodeUtils.make(expnums);
        
        ListNode val = target.reverseKGroup(testdata,3);
        ListNodeUtils.print(val);

        assertTrue(ListNodeUtils.assertListNode(val, exp));
    }

    @Test public void test3(){
        ReverseNodesinkGroupSolution target = new ReverseNodesinkGroupSolution();
        int[] nums = {1,2,3,4,5};
        ListNode testdata = ListNodeUtils.make(nums);
        int[] expnums = {2,1,4,3,5};

        ListNode exp = ListNodeUtils.make(expnums);
        
        ListNode val = target.reverseKGroupV2(testdata,2);
        ListNodeUtils.print(val);

        assertTrue(ListNodeUtils.assertListNode(val, exp));
    }

    @Test public void test4(){
        ReverseNodesinkGroupSolution target = new ReverseNodesinkGroupSolution();
        int[] nums = {1,2,3,4,5};
        ListNode testdata = ListNodeUtils.make(nums);
        int[] expnums = {3,2,1,4,5};

        ListNode exp = ListNodeUtils.make(expnums);
        
        ListNode val = target.reverseKGroupV2(testdata,3);
        ListNodeUtils.print(val);

        assertTrue(ListNodeUtils.assertListNode(val, exp));
    }
}
