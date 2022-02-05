package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourSumSolution {
    /**
     * int型配列とtarget（値）を与えられた時、4つの値でtargetとなる組み合わせ結果を返却する関数
     * 
     * @param nums   int型配列
     * @param target int型の値
     * @return 4つの値でtargetとなる組み合わせ結果のリスト
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // 前処理
        // 配列→リスト変換用のリスト
        List<Integer> listnums = new ArrayList<>();

        // 配列→リスト変換
        for (int num : nums) {
            listnums.add(num);
        }
        // 引数のINT配列（リスト）をソート
        // ※後続の2sum実施時に検索を高速化するためにソートされている必要がある。
        // また、ソート処理は、時間がかかるため大元をソートすることでソート処理を1回としている
        Collections.sort(listnums);

        // 返却値用のリスト
        List<List<Integer>> ansList = new ArrayList<>();
        // 前回の値を保持する変数
        int dictnum = 0;
        // 初回実行判定用フラグ
        boolean flg = true;

        // 配列のサイズ分実行
        while (listnums.size() > 0) {
            // 先頭の値を取得
            int num = listnums.get(0);
            // 先頭の値をリストから削除
            listnums.remove(0);

            // 初回実行時または前回と異なる値(num)の時に実行
            if (flg || dictnum != num) {
                // 3sum呼び出し時の引数用のリスト
                List<Integer> tempnums = new ArrayList<>(listnums);
                // 重複確認用のリスト
                List<List<Integer>> templist = threeSumExpantion(tempnums, num, target);

                // 結果の重複確認
                for (List<Integer> intList : templist) {
                    if (!ansList.contains(intList)) {
                        ansList.add(intList);
                    }
                }

                // 初回実行フラグを変更
                flg = false;
                // 前回の値を更新
                dictnum = num;
            }else{
                // 何もなし
            }

        }

        return ansList;
    }

    /**
     * int型リストとtarget（値）と1つの値(bscNum)を与えられた時、bscNum+3つの値でtargetとなる組み合わせ結果を返却する関数
     * 
     * @param nums   int型配列
     * @param bscNum int型の値
     * @param target int型の値
     * @return bscNum+3つの値でtargetとなる組み合わせ結果のリスト
     */
    private List<List<Integer>> threeSumExpantion(List<Integer> nums, int bscNum, int target) {

        // 返却値用のリスト
        List<List<Integer>> ansList = new ArrayList<>();

        // 主処理
        // 引数のINT配列（リスト）のサイズ分繰り返し
        while (nums.size() > 0) {
            // 先頭の値を取得
            int num = nums.get(0);
            // 先頭の値をリストから削除
            nums.remove(0);

            // 作業用のリスト作成（リストコピー） いらない
            List<Integer> listnumsCp = new ArrayList<>(nums);
            // 先頭インデックス、最後尾インデックス用のカウンター
            int fisrtInd = 0;
            int lastInd = listnumsCp.size() - 1;

            // 先頭の値と残りリスト内の先頭インデックスの値、最後尾インデックスの値の和が0の場合、返却値リストに格納
            // 先頭の値と残りリスト内の先頭インデックスの値、最後尾インデックスの値の和が0が0未満の場合、先頭インデックスカウンターをインクリメント
            // 先頭の値と残りリスト内の先頭インデックスの値、最後尾インデックスの値の和が0が0以上の場合、最後尾インデックスカウンターをデクリメント
            while (fisrtInd < lastInd) {

                if ((listnumsCp.get(fisrtInd).intValue() + listnumsCp.get(lastInd).intValue() + num
                        + bscNum) == target) {
                    List<Integer> intList = new ArrayList<>();
                    intList.add(bscNum);
                    intList.add(num);
                    intList.add(listnumsCp.get(fisrtInd));
                    intList.add(listnumsCp.get(lastInd));
                    Collections.sort(intList);
                    if (!ansList.contains(intList)) {
                        ansList.add(intList);
                    }
                    fisrtInd++;
                } else if (num + bscNum + listnumsCp.get(fisrtInd).intValue()
                        + listnumsCp.get(lastInd).intValue() < target) {
                    fisrtInd++;
                } else {
                    lastInd--;
                }

            }

        }

        return ansList;
    }
}
