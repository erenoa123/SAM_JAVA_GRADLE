package demo;

public class RemoveNthNodeFromEndofListSolution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode calHead = head;
        int cnt = 0;
        int target = 0;

        // リストサイズを確認
        while (calHead != null) {
            calHead = calHead.next;
            cnt++;
        }

        // 0件リストの場合、null返却
        if (cnt == 0) {
            return null;
        }

        target = cnt - n + 1;
        cnt = 0;
        calHead = head;
        ListNode retnode = null;
        ListNode tempNode = new ListNode();

        // 返却用リストの再作成
        while (calHead != null) {
            cnt++;

            // 削除ノードにヒットしたら追加せずスキップ
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
