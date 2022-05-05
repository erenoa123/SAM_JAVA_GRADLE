package demo;

public class PalindromeNumberSolution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        int tmp = x;
        int rev = 0;
        while(tmp > 0){
            rev = tmp % 10 + rev * 10;
            tmp = tmp / 10;
        }
        
        if((x - rev) == 0){
            return true;
        }else{
            return false;
        }
        
    }
}
