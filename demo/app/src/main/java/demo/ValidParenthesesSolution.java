package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidParenthesesSolution {
    public boolean isValid(String s) {
        
        Map<String, String> isValidMap = makeMap();

        String[] arrStr = s.split("");

        List<String> arrPreStr = new ArrayList<>();

        // 引数Sの分実行
        for(String str : arrStr){

            // ()が閉じている場合と最初はarrPreStrに追加のみ
            if(arrPreStr.isEmpty()){
                arrPreStr.add(str);
                continue;
            }

            // strと１文字前（arrPreStrの最新値）の値の閉じ括弧を比較
            if(str.equals(isValidMap.get(arrPreStr.get(arrPreStr.size() -1)))){
                // 想定通りの閉じ括弧の場合、arrPreStrから削除
                arrPreStr.remove(arrPreStr.size() -1);
            // strが想定の閉じ括弧でない場合、かつ開き括弧（isValidMapのキー値）の場合
            }else if(isValidMap.containsKey(str)){
                // arrPreStrに追加
                arrPreStr.add(str);
            // strが想定の閉じ括弧でない場合、かつ開き括弧でもない場合
            }else {
                return false;
            }
        }

        // arrPreStrに値が残っている場合（閉じ括弧がない場合）
        if(!arrPreStr.isEmpty()){
            return false;
        }

        return true;
    }

    private Map<String, String> makeMap(){

        Map<String, String> isValidMap = new HashMap<>();

        isValidMap.put("(", ")");
        isValidMap.put("[", "]");
        isValidMap.put("{", "}");

        return isValidMap;

    }
}
