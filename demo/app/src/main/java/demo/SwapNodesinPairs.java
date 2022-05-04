package demo;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {

        // 作業用のListNodeを作成
        ListNode work = head;
        // 2回に1回swap用のフラグ
        boolean flg = false;
        
        // 入力がnullの場合
        if(head == null){
            return null;
        }

        // リストが1件の場合
        if(head.next == null){
            return head;
        }

        //　返却用のListNodeを作成
        ListNode ret = new ListNode();
        // swap単位にリストで管理する
        List<ListNode[]> list = new ArrayList<>();
        // swap対象のnode格納用配列
        ListNode[] arr = new ListNode[2];

        // 主処理
        // swap対象のnodeを特定
        while(work != null){
            if(flg){
                arr[1] = work;
                list.add(arr);
                arr = new ListNode[2];
                flg = false;
            }else{
                arr[0] = work;
                flg = true;

                // リストが奇数の場合、
                if(work.next == null){
                    arr[1] = arr[0];
                    list.add(arr);
                }
            }
            work = work.next;    
        }

        ListNode prv = ret;

        //　swap処理
        for(ListNode[] nodearr : list){
            nodearr[1].next = nodearr[0];
            prv.next = nodearr[1];
            prv = nodearr[0];
        }
        prv.next = null;

        return ret.next;
    }
}
