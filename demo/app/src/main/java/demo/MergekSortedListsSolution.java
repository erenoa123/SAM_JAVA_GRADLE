package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergekSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // 最終ノードを格納用
        Map<Integer, ListNode> nodelstMap = new HashMap<Integer, ListNode>();
        // 先頭ノードを格納用
        Map<Integer, ListNode> nodefstMap = new HashMap<Integer, ListNode>();

        // 全ノードにアクセスする
        for (ListNode node : lists) {
            while (node != null) {
                // mapに未格納の場合、設定
                // mapに格納済みの場合、後続に設定し最終ノード用のmapの値を更新
                if (!nodelstMap.containsKey(node.val)) {
                    ListNode temp = new ListNode();
                    temp.val = node.val;
                    nodelstMap.put(temp.val, temp);
                    nodefstMap.put(temp.val, temp);
                } else {
                    ListNode temp = new ListNode();
                    temp.val = node.val;
                    nodelstMap.get(node.val).next = temp; 
                    nodelstMap.replace(node.val, temp);
                }
                node = node.next;
            }
        }

        ListNode tempNode = null;
        ListNode retNode = null;

        // キーをソートする
        List<Integer> keyList = new ArrayList<>(nodelstMap.keySet());
        keyList.sort((s1, s2)->s1.compareTo(s2));

        // 返却用のListNodeを作成
        for(Integer key : keyList){
            if(retNode == null){ 
                retNode = nodefstMap.get(key);
                tempNode = nodelstMap.get(key);
            }else{
                tempNode.next = nodefstMap.get(key);
                tempNode = nodelstMap.get(key);
            }
        }

        return retNode;
    }

}
