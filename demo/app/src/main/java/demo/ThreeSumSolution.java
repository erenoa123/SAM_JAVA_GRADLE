package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {

        int cnt = 0;
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> firstnum = new ArrayList<>();
        
        for(int num : nums){

            if(firstnum.contains(num)){
                cnt++;
                continue;
            }

            List<Integer> secondnum = new ArrayList<>();
            
            for(int i = cnt+1 ; i < nums.length ; i++){

                if(secondnum.contains(i)){
                    continue;
                }

                int twosum = num + nums[i];
                for(int j = i + 1; j < nums.length ; j ++){
                    if((twosum + nums[j]) == 0){
                        List<Integer> intList = new ArrayList<>();
                        intList.add(num);
                        intList.add(nums[i]);
                        intList.add(nums[j]);
                        Collections.sort(intList);
                        if(!ansList.contains(intList)){
                                                       
                            ansList.add(intList);
                        }
                    }
                }
                secondnum.add(nums[i]);
            }
            firstnum.add(num);
            cnt++;
        }

        return ansList;
    }
}
