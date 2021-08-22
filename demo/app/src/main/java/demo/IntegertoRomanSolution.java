package demo;

import java.util.HashMap;
import java.util.Map;

public class IntegertoRomanSolution {
    public String intToRoman(int num) {
        
        Map<Integer,String> map1keta = mapKeta("I","V","X");

        String keta1 = map1keta.get(num%10);
        if(keta1 == null){
            keta1 = "";
        }
        num = num /10;

        Map<Integer,String> map10keta = mapKeta("X","L","C");

        String keta10 = map10keta.get(num%10);
        if(keta10 == null){
            keta10 = "";
        }
        num = num /10;

        Map<Integer,String> map100keta = mapKeta("C","D","M");

        String keta100 = map100keta.get(num%10);
        if(keta100 == null){
            keta100 = "";
        }
        num = num /10;

        Map<Integer,String> map1000keta = new HashMap<>();
        map1000keta.put(1,"M");
        map1000keta.put(2,"MM");
        map1000keta.put(3,"MMM");

        String keta1000 = map1000keta.get(num%10);
        if(keta1000 == null){
            keta1000 = "";
        }
  
        return keta1000+keta100+keta10+keta1;
        
    }

    private Map<Integer,String> mapKeta(String one, String five, String ten){

        Map<Integer,String> mapketa = new HashMap<>();
        mapketa.put(1,one);
        mapketa.put(2,one+one);
        mapketa.put(3,one+one+one);
        mapketa.put(4,one+five);
        mapketa.put(5,five);
        mapketa.put(6,five+one);
        mapketa.put(7,five+one+one);
        mapketa.put(8,five+one+one+one);
        mapketa.put(9,one+ten);

        return mapketa;
    }

}
