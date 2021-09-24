package demo;

class RomantoIntegerSolution {
    public int romanToInt(String s) {
       
        String arrS[] = s.split("");
        int ans = 0;
        int cnt = 0;
        boolean flg = false;
        String ch = "";
        for(String cS : arrS){
            
            if(flg){
                flg = false;
            }else{
                ch = cS;
            }

            if(cnt+1 < s.length() && ch.equals("I")){
                if(arrS[cnt+1].equals("V")){
                    ch += "V";
                    cnt++;
                    flg = true;
                    continue;
                }else if(arrS[cnt+1].equals("X")){
                    ch += "X";
                    cnt++;
                    flg = true;
                    continue;
                }
            }

            if(cnt+1  < s.length() && ch.equals("X")){
                if(arrS[cnt+1].equals("L")){
                    ch += "L";
                    cnt++;
                    flg = true;
                    continue;
                }else if(arrS[cnt+1].equals("C")){
                    ch += "C";
                    cnt++;
                    flg = true;
                    continue;
                }
            }

            if(cnt+1  < s.length() && ch.equals("C")){
                if(arrS[cnt+1].equals("D")){
                    ch += "D";
                    cnt++;
                    flg = true;
                    continue;
                }else if(arrS[cnt+1].equals("M")){
                    ch += "M";
                    cnt++;
                    flg = true;
                    continue;
                }
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
}