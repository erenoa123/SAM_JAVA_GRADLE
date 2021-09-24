package demo;

class RomantoIntegerSolution {
    public int romanToInt(String s) {
       
        String arrS[] = s.split("");
        int ans = 0;
        int cnt = 0;
        boolean flg = false;
        String ch = "";
        for(String cS : arrS){
            
            if(cnt+1 < s.length() && handan(cS,arrS[cnt+1])){
                cnt++;
                ch = cS;
                flg = true;
                continue;
            }

            if(flg){
                ch += cS;
                flg = false;
            }else{
                ch = cS;
            }

            switch(ch){
                case "I" : ans += 1; break;
                case "V" : ans += 5; break;
                case "X" : ans += 10; break;
                case "L" : ans += 50; break;
                case "C" : ans += 100; break;
                case "D" : ans += 500; break;
                case "M" : ans += 1000; break;
                case "IV" : ans += 4; break;
                case "IX" : ans += 9; break;
                case "XL" : ans += 40; break;
                case "XC" : ans += 90; break;
                case "CD" : ans += 400; break;
                case "CM" : ans += 900; break;
                default : break;
            }

            cnt++;
        }

        return ans;
    }

    private boolean handan(String ch, String arrS){
        if(ch.equals("I")){
            if(arrS.equals("V")){
                return  true;
            }else if(arrS.equals("X")){
                return  true;
            }
        }

        if(ch.equals("X")){
            if(arrS.equals("L")){
                return  true;
            }else if(arrS.equals("C")){
                return  true;
            }
        }

        if(ch.equals("C")){
            if(arrS.equals("D")){
                return  true;
            }else if(arrS.equals("M")){
                return  true;
            }
        }
        return false;
    }
}