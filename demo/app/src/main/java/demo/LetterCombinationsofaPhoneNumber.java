package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {

        // 前処理
        // phonenumberに対応する文字列リストを作成
        // 入力値を配列へ変換
        String[][] strAry = setUp();
        String[] digitsAry = digits.split("");

        // 入力値が空の場合、空のリストを返却
        // 入力値が1桁の場合、組み合わせ処理を実施せずリストを作成して返却
        if (digits.isEmpty()) {
            return new ArrayList<>();
        } else if (digits.length() == 1) {
            return Arrays.asList(strAry[Integer.parseInt(digitsAry[0])]);
        }

        // 返却値リストを作成
        List<String> retList = combination(Arrays.asList(strAry[Integer.parseInt(digitsAry[0])]),
                strAry[Integer.parseInt(digitsAry[1])]);

        // 入力値が2桁以上の場合は、返却値リストとの組み合わせをさらに実施
        for (int i = 2; i < digits.length(); i++) {
            retList = combination(retList, strAry[Integer.parseInt(digitsAry[i])]);

        }

        return retList;
    }

    /**
     * 与えられた2つのリストの組み合わせ結果を返却する
     * 
     * @param parentList
     * @param childList
     * @return 組み合わせ結果
     */
    private List<String> combination(List<String> parentList, String[] childList) {

        List<String> retList = new ArrayList<>();

        for (String s : parentList) {
            for (String chi : childList) {
                retList.add(s + chi);
            }
        }
        return retList;

    }

    /**
     * phoneNumberに対応する文字列の初期設定
     * 
     * @return
     */
    private String[][] setUp() {

        String[][] strarr = {
                {},
                {},
                { "a", "b", "c" },
                { "d", "e", "f" },
                { "g", "h", "i" },
                { "j", "k", "l" },
                { "m", "n", "o" },
                { "p", "q", "r", "s" },
                { "t", "u", "v" },
                { "w", "y", "x", "z" }
        };

        return strarr;

    }
}