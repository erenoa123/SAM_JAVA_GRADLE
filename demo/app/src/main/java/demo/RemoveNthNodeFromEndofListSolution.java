package demo;

public class RemoveNthNodeFromEndofListSolution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode calHead = head;
        int cnt = 0;
        int target = 0;

        while (calHead != null) {

            calHead = calHead.next;

            cnt++;

        }

        if (cnt == 0) {
            return null;
        }

        target = cnt - n + 1;
        cnt = 0;
        calHead = head;
        ListNode retnode = null;
        ListNode tempNode = new ListNode();

        while (calHead != null) {
            cnt++;

            if (cnt == target) {
                calHead = calHead.next;
                continue;
            }

            if (retnode == null) {
                retnode = new ListNode(calHead.val);
                tempNode = retnode;
            } else {
                ListNode node = new ListNode(calHead.val);
                tempNode.next = node;
                tempNode = node;
            }

            calHead = calHead.next;

        }

        return retnode;
    }

}
