package demo;


public class MergeTwoSortedListsSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode node1 = list1;
        ListNode node2 = list2;

        ListNode retNode = null;
        ListNode tempNode = new ListNode();

        // list1またはlist2がnullになるまで繰り返し
        while(node1 != null || node2 != null){

            //初回実行時用
            if(retNode == null){

                // node1がnull以外かつnode2がnullまたは、node1の値がnode2の値より小さい場合
                if(node1 != null && (node2 == null || node1.val < node2.val)){
                    ListNode node = new ListNode(node1.val);
                    tempNode = node;
                    retNode = tempNode;
                    node1 = node1.next;
                }else{
                    ListNode node = new ListNode(node2.val);
                    tempNode = node;
                    retNode = tempNode;
                    node2 = node2.next;
                }
                continue;
            }

            // node1がnull以外かつnode2がnullまたは、node1の値がnode2の値より小さい場合
            if(node1 != null && (node2 == null || node1.val < node2.val)){
                ListNode node = new ListNode(node1.val);
                tempNode.next = node;
                tempNode = node;
                node1 = node1.next;
            }else{
                ListNode node = new ListNode(node2.val);
                tempNode.next = node;
                tempNode = node;
                node2 = node2.next;
            }

        }


        return retNode;
    }
}
