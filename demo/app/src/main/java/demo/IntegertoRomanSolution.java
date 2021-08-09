package demo;

public class IntegertoRomanSolution {
    public String intToRoman(int num) {
        
        String keta1 = "";

        if(num%10 > 0){
            if(num%10 == 4){
                keta1 = "IV";
            }else if(num%10 == 5){
                keta1 = "V";
            }else if(num%10 == 9){
                keta1 = "IX";
            }else {
                int i = 0;
                while(i < num%10){
                    if(i == 0 && num%10 > 5){
                        keta1 = "V";
                        i = i + 5;
                    }else{
                        keta1 = keta1 + "I";
                        i++;
                    }
                }
            }
        }

        String keta10 = "";
        num = num /10;
        if(num%10 > 0){
            if(num%10 == 4){
                keta10 = "XL";
            }else if(num%10 == 5){
                keta10 = "L";
            }else if(num%10 == 9){
                keta10 = "XC";
            }else {
                int i = 0;
                while(i < num%10){
                    if(i == 0 && num%10 > 5){
                        keta10 = "L";
                        i = i + 5;
                    }else{
                        keta10 = keta10 + "X";
                        i++;
                    }
                }
            }
        }

        String keta100 = "";
        num = num /10;
        if(num%10 > 0){
            if(num%10 == 4){
                keta100 = "CD";
            }else if(num%10 == 5){
                keta100 = "D";
            }else if(num%10 == 9){
                keta100 = "CM";
            }else {
                int i = 0;
                while(i < num%10){
                    if(i == 0 && num%10 > 5){
                        keta100 = "D";
                        i = i + 5;
                    }else{
                        keta100 = keta100 + "C";
                        i++;
                    }
                }
            }
        }

        String keta1000 = "";
        num = num /10;
        if(num%10 > 0){
            int i = 0;
            while(i < num%10){
                keta1000 = keta1000 + "M";
                i++;
            }
        
        }

        return keta1000+keta100+keta10+keta1;
        

    }
}
