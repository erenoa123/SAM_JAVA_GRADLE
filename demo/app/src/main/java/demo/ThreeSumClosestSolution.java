package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSumClosestSolution {
    public int threeSumClosest(int[] nums, int target) {
        
        // 前処理
        // 配列→リスト変換用のリスト
        List<Integer> listnums = new ArrayList<>();

        // 配列→リスト変換
        for(int num : nums){
            listnums.add(num);
        }
        // 引数のINT配列（リスト）をソート
        // ※後続の2sum実施時に検索を高速化するためにソートされている必要がある。
        // また、ソート処理は、時間がかかるため大元をソートすることでソート処理を1回としている
        Collections.sort(listnums);

        // 返却値用の変数
        int ans = 999999;
        
        // 主処理
        // 引数のINT配列（リスト）のサイズ分繰り返し
        while(listnums.size() > 0){
            // 先頭の値を取得
            int num = listnums.get(0);
            // 先頭の値をリストから削除
            listnums.remove(0);

            // 作業用のリスト作成（リストコピー）　いらない
            List<Integer> listnumsCp = new ArrayList<>(listnums);
            // 先頭インデックス、最後尾インデックス用のカウンター
            int fisrtInd = 0;
            int lastInd = listnumsCp.size()-1;
            
            // 先頭の値と残りリスト内の先頭インデックスの値、最後尾インデックスの値の和が0の場合、返却値リストに格納
            // 先頭の値と残りリスト内の先頭インデックスの値、最後尾インデックスの値の和が0が0未満の場合、先頭インデックスカウンターをインクリメント
            // 先頭の値と残りリスト内の先頭インデックスの値、最後尾インデックスの値の和が0が0以上の場合、最後尾インデックスカウンターをデクリメント
            while(fisrtInd < lastInd){
  
                if(ans == 999999  || Math.abs(target - (listnumsCp.get(fisrtInd).intValue() + listnumsCp.get(lastInd).intValue() + num)) < Math.abs(target - ans)){
                    ans = listnumsCp.get(fisrtInd).intValue() + listnumsCp.get(lastInd).intValue() + num;
                
                }

                if(target < listnumsCp.get(fisrtInd).intValue() + listnumsCp.get(lastInd).intValue() + num){
                    lastInd--;
                }else{
                    fisrtInd++;
                }

            }

        }

        return ans;
    }
}
