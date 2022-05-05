package demo;

import java.util.ArrayList;
import java.util.List;

public class MedianofTwoSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int cnt1=0;
        int cnt2=0;
        List<Integer> ans = new ArrayList<>();
        
        int num1 = 0;
        int num2 = 0;
        
        boolean flg1 = false;
        boolean flg2 = false;
        
        while(cnt1 < nums1.length || cnt2 < nums2.length){
            
            if(cnt1 >= nums1.length){
                flg1 = true;
            }else{
                num1 = nums1[cnt1];
            }
            
            if(cnt2 >= nums2.length){
                flg2 = true;
            }else{
                num2 = nums2[cnt2];
            }
            
            if(flg1){
                ans.add(num2);
                cnt2++;
            }
            
            if(flg2){
                ans.add(num1);
                cnt1++;
            }
            
            if(num1 <= num2 && !flg1 && !flg2){
                ans.add(num1);
                cnt1++;
            }else if(!flg1 && !flg2){
                ans.add(num2);
                cnt2++;
            }
            
        }
        
        double retAns = 0;
        
        if(ans.size()%2 == 0){
            retAns = (double)(ans.get(ans.size()/2 -1) + ans.get(((ans.size()/2)))) /2;
            
        }else{
            retAns = ans.get(ans.size()/2);
        }
        
        return retAns;
        
    }
}
