package demo;
/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
class Solution {
    /** 
     * 仕様検討メモ
     * 1 < 2 < 3 < 4
     *   < 2 < 4 > 3
     *   < 3 > 2 < 4
     *   < 3 < 4 > 2
     *   < 4 > 2 < 3
     *   < 4 > 3 > 2
     * 2 > 1 < 3 < 4
     * 
     * 
     * ①最後尾の組み合わせが左辺 < 右辺になっている場合、左辺 > 右辺となるように入れ替える
     * ②最後尾の組み合わせが左辺 > 右辺になっている場合、最後尾-n番目の左辺 < 右辺となっている組み合わせを探す。
     * ③最後尾-n番目の組み合わせが左辺 < 右辺の場合、最後尾から最後尾-n+1番目までの値のうち、最後尾-n番目の値の次に大きい値を最後尾-n番目に格納し、最後尾から最後尾-n+1番目までを昇順ソートする
     * ④左辺 < 右辺の組み合わせがない場合、対象配列を昇順ソートする。
     * ⑤対象配列のサイズが1の場合、何もせず終了
    */
    public void nextPermutation(int[] nums) {

        // 最後尾のIndex値を格納
        int lastIndex = nums.length - 1;

        // 仕様⑤以外かつ①の場合
        if (lastIndex != 0 &&
            nums[lastIndex - 1] < nums[lastIndex]) {
            int tmp = nums[lastIndex];
            nums[lastIndex] = nums[lastIndex - 1];
            nums[lastIndex - 1] = tmp;
        
        // 仕様⑤以外の場合、②③④を実行
        } else if(lastIndex != 0) {

            // 最後尾から検査済みの値格納用のリスト
            List<Integer> numList = new ArrayList<>();
            numList.add(nums[lastIndex]);

            // 仕様④判定用のフラグ
            boolean flg = true;

            // 仕様②③の主処理
            for (int i = lastIndex - 1; i >= 0; i--) {

                // 検査対象を格納
                numList.add(nums[i]);

                // 仕様②の場合
                if (nums[i] < nums[i + 1]) {
                    //　検査済みの値を昇順ソート
                    Collections.sort(numList);

                    // 仕様③
                    // 最後尾-n番目（nums[i]）の値の次に大きい値のindexを取得
                    int nextlrgNum = nextlargenum(nums[i], numList);
                    // 最後尾-n番目の値の次に大きい値を最後尾-n番目に格納
                    nums[i] = numList.get(nextlrgNum);
                    numList.remove(nextlrgNum);
                    
                    // 最後尾から最後尾-n+1番目までを昇順ソートで格納
                    int ind = 0;
                    for (int j = i + 1; j <= lastIndex; j++) {
                        nums[j] = numList.get(ind++);
                    }

                    // 仕様④をスキップするためfalse
                    flg = false;
                    break;
                }
            }

            // 仕様⑤
            if (flg) {
                int ind = 0;
                Collections.sort(numList);
                for (int num : numList) {
                    nums[ind] = num;
                    ind++;
                }
            }

        }

    }

    private int nextlargenum(int num, List<Integer> numList){

        int retInd = 0;
        for(int i : numList){
            if(num < i){
                return retInd;
            }
            retInd++;
        }

        return retInd;

    }
}
// @lc code=end
