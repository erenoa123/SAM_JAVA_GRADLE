package demo;

public class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {
        String[] tS = s.split("");
        int size = tS.length;
        String ans = "";
        
        //１桁パターン
        if(size == 1){
            return s;
        }
        
        //メインロジック
        for(int i=0 ; i<size-1; i++){
            //奇数パターンを見つける
            String temp = tS[i+1];
            int min = 1;
            int max = 1;
            for(int j=i ; j<size-1; j++){
                if(((i+1-min) < 0)||((i+1+max) > size-1)){
                    break;
                }
                if(tS[i+1-min].equals(tS[i+1+max])){
                    temp = tS[i+1-min] + temp + tS[i+1+max];
                    min++;
                    max++;
                }else{
                    break;
                }
            }
            
            if(ans.length() < temp.length()){
                ans = temp;
            }
            
            //偶数パターンを見つける
            min = 0;
            max = 1;
            temp = "";
            for(int j=i ; j<=size-1; j++){
                if(tS[i-min].equals(tS[i+max])){
                    temp = tS[i-min] + temp + tS[i+max];
                    min++;
                    max++;
                }else{
                    break;
                }
                
                if(((i - min) < 0)||((i + max) > size-1)){
                    break;
                }
            }
            
            if(ans.length() < temp.length()){
                ans = temp;
            }

        }

                
        return ans;
        
        
        
    }
}
