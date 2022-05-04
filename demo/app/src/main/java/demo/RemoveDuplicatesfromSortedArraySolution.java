package demo;

public class RemoveDuplicatesfromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        Integer curNum = 0;
        for(Integer n : nums){
            if(cnt == 0){
                curNum = n;
                cnt++;
            }

            if(curNum != n){
                curNum = n;
                nums[cnt] = curNum;
                cnt++;
            }
        }
        return cnt;
    }
}
