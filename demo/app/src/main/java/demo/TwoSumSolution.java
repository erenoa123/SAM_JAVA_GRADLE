package demo;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        int cnt = 0;
        int i;
        boolean frg = false;
        int ret[] = new int[2];
        for(int num : nums){
            cnt++;
            for(i = cnt ; i < nums.length ; i++){
                if((num + nums[i]) == target ){
                    frg = true;
                    ret[0] = cnt - 1;
                    ret[1] = i;
                    break;
                }
            }
            
            if(frg){
                break;
            }
        }
        
        return ret;
    }
}
