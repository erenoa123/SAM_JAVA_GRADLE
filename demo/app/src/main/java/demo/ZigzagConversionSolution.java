package demo;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversionSolution {
    public String convert(String s, int numRows) {
        String[] ab =s.split("(?!^)");
        List<String> ans = new ArrayList<>();
        int cnt = numRows;
        
        while(cnt > 0){
            ans.add("");
            cnt--;
        }
        
        int size = ab.length;
        cnt = numRows;
        int readcnt = 0;
        
        while(size > 0){
            if(cnt == numRows){
                int i = 0;
                for(i = 0; i < numRows; i++){
                    ans.set(i,ans.get(i)+ab[readcnt]);
                    readcnt++;
                    size--;
                    if(readcnt >= ab.length){
                        break;
                    }
                }
                cnt--;
            }else{
                ans.set(cnt-1,ans.get(cnt-1)+ab[readcnt]);
                readcnt++;
                size--;
                cnt--;
            }
            
            if(cnt <= 1){
                cnt=numRows;
            }

            
        }
        
        String returnAns ="";
        
        for(String str: ans){
            returnAns = returnAns + str;
        }
        
        return returnAns;
        
    }
}
