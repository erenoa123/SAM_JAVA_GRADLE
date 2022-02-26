package demo;

import org.junit.Test;

public class RemoveNthNodeFromEndofListSolutionTest {
    @Test public void test1(){
        RemoveNthNodeFromEndofListSolution target = new RemoveNthNodeFromEndofListSolution();
        
        int testdata1[] = {5,4,3,2,1};

        ListNode node = makeTestData(testdata1);

        ans(target.removeNthFromEnd(node,2));
    }

    private ListNode makeTestData(int[] arrInt){

        ListNode retnode = null;

        for(int i : arrInt){

            if(retnode == null){
                ListNode node = new ListNode(i,null);
                retnode = node;
            }else{
                ListNode node = new ListNode(i,retnode);
                retnode = node;
            }

            
        }

        return retnode;
    }

    private void ans(ListNode node){
        System.out.println("結果");
        while(node.next != null){

            System.out.println(node.val);

            node = node.next;

        }
    }
}
