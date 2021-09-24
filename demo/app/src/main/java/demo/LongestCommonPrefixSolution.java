package demo;

public class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        
        String ans = strs[0];
        for(String str : strs){
            int cnt = 0;
            String temp = "";
            for(String ch : ans.split("")){
                if(str.length() > cnt && ch.equals(str.split("")[cnt++])){
                    temp += ch;
                }else{
                    break;
                }
            }
            ans = temp;
        }

        return ans;
    }
}
