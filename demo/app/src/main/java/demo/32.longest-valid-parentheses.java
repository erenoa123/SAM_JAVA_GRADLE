package demo;
/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 

     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        String[] str = s.split("");
        int maxCnt = 0;
        List<List<Integer>> ary = new ArrayList<>();
        
        for (String st: str){
            if(st.equals("(")){
                List<Integer> arTmp = new ArrayList<>();
                arTmp.add(1);
                ary.add(arTmp);
            }else if(st.equals(")")){
                boolean flg = true;
                for(int i=ary.size()-1 ; i >=0 ; i--){
                    if(ary.get(i).size() ==1){
                        ary.get(i).add(1);
                        flg = false;
                        break;
                    }
                }
                if(flg){
                    List<Integer> arTmp = new ArrayList<>();
                    ary.add(arTmp);   
                }
            }
        }  

        int chk = 0;
        for(List<Integer> lst : ary){
            if(lst.size() == 2){
                chk++;
                if(chk > maxCnt){
                    maxCnt = chk;
                }
            }else{
                chk = 0;
            }
        }
        return maxCnt*2;
    }
}
// @lc code=end
