package demo;

public class RemoveElementSolution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(Integer n : nums){
            if(val != n){
                nums[cnt] = n;
                cnt++;
            }
        }
        return cnt;
    }
}
