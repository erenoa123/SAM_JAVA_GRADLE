package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringtoIntegeratoiSolution {
    public int myAtoi(String s) {
        
        //判定用の変数初期化
        List<String> list = makeList();
        Map<String, Integer> map = makeMap();
        
        //返却用の値の格納先一時的
        List<Integer> ansList = new ArrayList<Integer>();
                
        String str = s;
        str = str.trim();
        //文字列を1文字づつ取り出す
        String[] strArray = str.split("");
        
        int fugou = 1;
        boolean fgflg = false;
        
        for(String s1 : strArray) {
            boolean flg = false;
            System.out.println(s1);
        	for(String tmpStr : list){
                if(tmpStr.equals(s1)){
                    if(s1.equals("+")){
                        if(!fgflg && ansList.size() == 0)
                         fugou = 1;
                        flg = false; 
                        
                        if(ansList.size() > 0){
                            flg = true;
                        }
                        
                        if(fgflg && ansList.size() == 0){
                          return 0;
                        }else{
                          fgflg = true;                            
                        }                                        
                        break;
                    }else if(s1.equals("-")){
                        if(!fgflg && ansList.size() == 0)
                         fugou = -1;
                        flg = false;
                        
                        if(ansList.size() > 0){
                            flg = true;
                        }
                        
                        if(fgflg && ansList.size() == 0){
                          return 0;
                        }else{
                          fgflg = true;                            
                        }
                        break;
                    }else{
                        ansList.add(map.get(tmpStr));
                        flg = false;
                        break;
                    }                    
                }else{
                    flg = true;
                }                             
            }
            
            if(flg){
                break;
            }
            
        }
       
        int cnt = 0;
        List<Integer> tmp = new ArrayList<Integer>(ansList);
        
        for(Integer i : tmp){
            if(i == 0){
               ansList.remove(cnt); 
            }else{
                break;
            }
        }
        
        if(ansList.size() > 10){
            if(fugou < 0){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        
        int ans = 0;
        for(Integer i : ansList){
           
            if(fugou < 0){
                if(ans*fugou < -214748364){
                  return Integer.MIN_VALUE;
                }else if((ans*fugou <= -214748364) && (i > 8)){
                  return Integer.MIN_VALUE;
                }
            }else {
                if(ans > 214748364){
                  return Integer.MAX_VALUE;
                }else if((ans >= 214748364) && (i > 7)){
                  return Integer.MAX_VALUE;                    
                }
            }
            
          ans = ans * 10 + i;
            
        }
        
        return ans * fugou;
    }
    
    private Map<String, Integer> makeMap(){
        Map<String, Integer> map = new HashMap<>();
        
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("0", 0);
        
        return map;
        
    }
    
    private List<String> makeList(){
        List<String> list = new ArrayList<String>();
        
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("+");
        list.add("-");
        
        return list;
        
    }
}
