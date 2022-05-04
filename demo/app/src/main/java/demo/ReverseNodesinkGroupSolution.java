package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseNodesinkGroupSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 作業用ノードを作成
        ListNode work = head;
        // 逆ソート単位のリストを作成
        List<Map<Integer, ListNode>> list = new ArrayList<>();
        // 逆ソート対象のノードを格納
        Map<Integer, ListNode> swapNodes = new HashMap<>();
        // リストサイズカウント用
        int size = 1;
        // マップのインデックス用
        int ind = 1;

        // 逆ソート対象のノードを選定
        // 逆ソート単位でリストを作成
        while (work != null) {
            // kの単位でlist.add
            if (size++ % k == 0) {
                swapNodes.put(ind++, work);
                list.add(swapNodes);
                // mapの初期化
                swapNodes = new HashMap<>();
                // インデックスの初期化
                ind = 1;
                work = work.next;
            } else {
                swapNodes.put(ind++, work);
                work = work.next;
                // 最終ノート場合、リストに追加
                if (work == null) {
                    list.add(swapNodes);
                }
            }
        }

        // 返却用のリストノード作成用
        ListNode tmp = new ListNode();
        // 返却用のノードを記憶用
        ListNode ret = tmp;

        for (Map<Integer, ListNode> map : list) {
            Integer[] mapkey = map.keySet().toArray(new Integer[map.size()]);
            // map.sizeがkの場合、逆ソートを実施
            if (map.size() % k == 0) {
                Arrays.sort(mapkey, Comparator.reverseOrder());
            }

            // 返却用にリストノードを繋ぎ直す
            for (Integer nKey : mapkey) {
                tmp.next = map.get(nKey);
                tmp = tmp.next;
            }
        }
        // 最終ノードのnextをnullに変更
        tmp.next = null;

        return ret.next;

    }

    public ListNode reverseKGroupV2(ListNode head, int k) {

        ListNode work = head;
        Map<Integer, ListNode> swapNodes = new HashMap<>();
        int ind = 1;
        ListNode tmp = new ListNode();
        ListNode ret = tmp;

        // 主処理
        while (work != null) {
            if (ind % k == 0) {
                swapNodes.put(ind++, work);
                work = work.next;
                tmp = reverseAndMakeNode(swapNodes, k, tmp);
                // 逆ソートした場合、tmp.nextがソート前の接続先になっているため、変更する
                tmp.next = work;
                // mapを初期化
                swapNodes.clear();
                ind = 1;
            } else {
                swapNodes.put(ind++, work);
                work = work.next;
            }
        }

        return ret.next;

    }

    /**
     * 逆ソートとノードの再接続を実施
     * 
     * @param map ソート対象のノード
     * @param k   ソート単位
     * @param tmp 返却用のリストノードのhead位置
     * @return 逆ソート後のリストノードのhead
     */
    private ListNode reverseAndMakeNode(Map<Integer, ListNode> map, int k, ListNode tmp) {

        Integer[] mapkey = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(mapkey, Comparator.reverseOrder());

        for (Integer nKey : mapkey) {
            tmp.next = map.get(nKey);
            tmp = tmp.next;
        }

        return tmp;

    }
}
