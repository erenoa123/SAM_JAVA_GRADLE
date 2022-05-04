package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateParenthesesSolution {
    public List<String> generateParenthesis(int n) {

        List<StringBuilder> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        str.append("");
        list.add(str);
        list = recursivePar(list, n);

        List<String> retList = new ArrayList<>();

        // 文字列のリストに変換
        for (StringBuilder sb : list) {
            retList.add(sb.toString());
        }

        return retList;
    }

    private List<StringBuilder> recursivePar(List<StringBuilder> list, int n) {

        List<StringBuilder> temp = new ArrayList<>();

        // 引数listの要素に"("を追加した文字列を追加
        // 引数listの要素に")"を追加した文字列を追加
        for (StringBuilder sb : list) {
            StringBuilder sbTemp = new StringBuilder(sb);
            temp.add(sbTemp.append("("));
            sbTemp = new StringBuilder(sb);
            temp.add(sbTemp.append(")"));
        }

        Iterator<StringBuilder> itr = temp.iterator();
        // 括弧を追加した要素が仕様通りでない場合、該当要素を削除する
        while (itr.hasNext()) {
            StringBuilder sb = itr.next();
            if (!check(sb, n)) {
                itr.remove();
            }
        }

        // 括弧を追加した要素が残っている場合、再帰処理を続行
        if (!temp.isEmpty()) {
            return recursivePar(temp, n);
        }

        return list;

    }

    /**
     * 要素が仕様通りかチェックする
     * ・'('がn個より多い場合、falseを返却
     * ・')'がn個より多い場合、falseを返却
     * ・'('より前に')'が存在しない場合、falseを返却
     * 
     * @param sb チェック対象の要素
     * @param n  括弧の最大数
     * @return 判定結果
     */

    private boolean check(StringBuilder sb, int n) {

        int cntOpen = 0;
        int cntClose = 0;
        int cnt = sb.length();
        int ind = 0;
        int flgCnt = 0;
        // 要素の先頭から開き括弧と閉じ括弧の数を数える
        while (cnt-- > 0) {
            if (sb.charAt(ind) == '(') {
                flgCnt++;
                cntOpen++;
            } else if (sb.charAt(ind) == ')') {

                // 閉じ括弧より前に開き括弧が存在しない場合（flgCntが0の場合）,falseを返却
                if (flgCnt != 0) {
                    flgCnt--;
                } else {
                    return false;
                }
                cntClose++;
            }
            ind++;
        }

        // 開き括弧がn個より多い場合、falseを返却
        if (cntOpen > n) {
            return false;
        }
        // 閉じ括弧がn個より多い場合、falseを返却
        if (cntClose > n) {
            return false;
        }

        return true;

    }
}
