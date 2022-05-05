package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWordsSolution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        // wordのサイズ
        int wordsSize = words[0].length();
        // wordsを連結後のサイズ
        int allWordsSize = 0;
        // words連結用
        String allWords = "";
        // wordカウント管理用
        Map<String, Integer> wordsMaruBatu = new HashMap<>();
        
        // words連結後のサイズ導出
        // wordカウント管理用map作成
        for(String str : words){
            allWords = allWords + str;
            //既にキーが存在している場合、valueをインクリメント
            if(wordsMaruBatu.containsKey(str)){
                wordsMaruBatu.replace(str, wordsMaruBatu.get(str) + 1);
            }else{
                wordsMaruBatu.put(str, 1);
            }            
        }
        allWordsSize = allWords.length();

        // words連結後のサイズ単位でsを分割する
        int fstInd = 0;
        int lastInd = allWordsSize;
        // 分割後のsを先頭文字位置をキーにして管理するmap
        Map<Integer, String> splitAllwords = new HashMap<>();

        // 1文字ずつずらしてwords連結後のサイズ単位で分割する
        while(lastInd <= s.length()){
            String renWord = s.substring(fstInd, lastInd);
            splitAllwords.put(fstInd,renWord);
            fstInd += 1;
            lastInd += 1; 
        }

        //　返却用のリスト
        List<Integer> ret = new ArrayList<>();

        // words連結後のサイズ単位で分割した文字列が該当文字列が判別する処理
        for(Integer nKey : splitAllwords.keySet()){
            Map<String, Integer> deepMap = new HashMap<>(wordsMaruBatu);
            if(check(deepMap, splitAllwords.get(nKey),wordsSize)){
                ret.add(nKey);
            }
        }

        return ret;

    }

    /**
     * 分割後文字列が該当文字列か判別する処理
     * @param wordsMaruBatu　wordカウント管理用map
     * @param splitAllword　分割後文字列
     * @param wordsSize　wordのサイズ
     * @return　分割後文字列が該当文字列の場合、true
     */
    private boolean check(Map<String, Integer> wordsMaruBatu, String splitAllword, int wordsSize){

        int fstInd = 0;
        int lastInd = wordsSize;

        // 分割後の文字列をwordサイズ単位で該当文字列か判別する
        while(lastInd <= splitAllword.length()){
            String word = splitAllword.substring(fstInd, lastInd);

            //  wordカウント管理用mapのキーに存在する場合、valueをデクリメント
            //　存在しない場合、falseを返却
            if(wordsMaruBatu.containsKey(word)){
                wordsMaruBatu.replace(word, wordsMaruBatu.get(word) - 1);
            }else{
                return false;
            }            
            fstInd = lastInd;
            lastInd += wordsSize; 
        }

        // wordカウント管理用mapのvalueが0以外の場合、falseを返却
        for(String nKey : wordsMaruBatu.keySet()){
            if(wordsMaruBatu.get(nKey) != 0){
                return false;
            }
        }

        return true;

    }
}
