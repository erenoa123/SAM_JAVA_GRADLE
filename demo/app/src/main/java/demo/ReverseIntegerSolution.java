package demo;

public class ReverseIntegerSolution {
    public int reverse(int x) {
        
        int anstmp = x;
        int ans = 0;
              
        while(anstmp != 0){
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && (anstmp%10) > 7)) return 0;
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && (anstmp%10) < -8)) return 0;
            ans = ans*10 +(anstmp%10);
            anstmp = anstmp / 10;
        }
        
        return ans;
        
    }
}
