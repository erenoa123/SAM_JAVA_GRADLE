package demo;

public class DivideTwoIntegersSolution {
    public int divide(int dividend, int divisor) {
        
        // dividendがInteger.MIN_VALUEの場合、trueとするフラグ
        boolean minFlg = false;

        // 即時リターン条件
        if(dividend == 0){
            return 0;
        }

        if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE){
                return 1;
            }
            return 0;
        }

        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }

        if(dividend == Integer.MAX_VALUE && divisor == 1){
            return Integer.MAX_VALUE;
        }

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        //　※１　dividendがInteger.MIN_VALUEであっても正の値として処理するための対応
        if(dividend == Integer.MIN_VALUE){
            dividend += 1;
            minFlg = true;
        }

        // Integer変換
        Integer sDividend = Integer.valueOf(dividend);
        Integer sDivisor = Integer.valueOf(divisor);

        // String変換
        String[] strDivid = sDividend.toString().split("");
        String[] strDivis = sDivisor.toString().split("");

        // 負の符号がついている場合、trueとするフラグ
        boolean dividFlg = false;
        boolean divisFlg = false;

        // index用のカウンタ
        int dividInd = 0;
        int divisInd = 0;

        // 負の符号
        final String BAR = "-";

        // マイナス値の場合、符号フラグをtrueにし、インデックスをインクリメント
        if(BAR.equals(strDivid[0])){
            dividFlg = true;
            dividInd++;
        }
        // マイナス値の場合、符号フラグをtrueにし、インデックスをインクリメント
        if(BAR.equals(strDivis[0])){
            divisFlg = true;
            divisInd++;
        }

        // 符号を除いたdivisorの作成
        String divis = "";
        while(divisInd < strDivis.length){
            divis = divis + strDivis[divisInd++];
        }

        String ret = "";
        String amari = "";
        Integer cnt = 0;
        
        // 主処理
        while(dividInd < strDivid.length){
            Integer dvd = Integer.valueOf(amari + strDivid[dividInd]);
            Integer dvs = Integer.valueOf(divis);
            if(dvd.compareTo(dvs) >=0 ){
                while(dvd >= dvs){
                    cnt++;
                    dvd -= dvs;
                }
                ret = ret + cnt.toString();
                amari = dvd.toString();
                cnt = 0;
            }else{
                ret = ret + "0";
                amari = dvd.toString();
            }
            dividInd++;
        }

        // ※１にて-1した分の辻褄合わせようの処理
        if(minFlg){
            if(Integer.valueOf(amari) + 1 >= Integer.valueOf(divis)){
                ret = Integer.valueOf((Integer.valueOf(ret) + 1)).toString();
            }         
        }

        // dividend、divisorのどちらか片方が負の場合
        // ＾は排他的論理和演算子
        if(dividFlg^divisFlg){
            ret = BAR + ret;
        }

        // retが空の場合
        if(ret.isBlank()){
            return 0;
        }
        return Integer.valueOf(ret);

    }
}
