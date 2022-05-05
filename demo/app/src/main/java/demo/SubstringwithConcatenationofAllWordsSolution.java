package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWordsSolution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        int wordsSize = words[0].length();
        int allWordsSize = 0;
        String allWords = "";
        Map<String, Integer> wordsMaruBatu = new HashMap<>();
        
        for(String str : words){
            allWords = allWords + str;
            if(wordsMaruBatu.containsKey(str)){
                wordsMaruBatu.replace(str, wordsMaruBatu.get(str) + 1);
            }else{
                wordsMaruBatu.put(str, 1);
            }            
        }
        allWordsSize = allWords.length();

        int fstInd = 0;
        int lastInd = allWordsSize;
        Map<Integer, String> splitAllwords = new HashMap<>();

        while(lastInd <= s.length()){
            String renWord = s.substring(fstInd, lastInd);
            splitAllwords.put(fstInd,renWord);
            fstInd += 1;
            lastInd += 1; 
        }

        List<Integer> ret = new ArrayList<>();

        for(Integer nKey : splitAllwords.keySet()){
            Map<String, Integer> deepMap = new HashMap<>(wordsMaruBatu);
            if(check(deepMap, splitAllwords.get(nKey),wordsSize)){
                ret.add(nKey);
            }
        }

        return ret;

    }

    private boolean check(Map<String, Integer> wordsMaruBatu, String splitAllword, int wordsSize){

        int fstInd = 0;
        int lastInd = wordsSize;

        while(lastInd <= splitAllword.length()){
            String word = splitAllword.substring(fstInd, lastInd);
            if(wordsMaruBatu.containsKey(word)){
                wordsMaruBatu.replace(word, wordsMaruBatu.get(word) - 1);
            }else{
                return false;
            }            
            fstInd = lastInd;
            lastInd += wordsSize; 
        }

        for(String nKey : wordsMaruBatu.keySet()){
            if(wordsMaruBatu.get(nKey) != 0){
                return false;
            }
        }

        return true;

    }
}
