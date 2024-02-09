import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(n-1).add(nums[n-1]);
        int ans_size = 1, ans_index = n-1;
        for(int i = n-2; i >= 0; i--){
            int sub_ans_size = 0, sub_ans_index = -1;
            for(int j = i+1; j < n; j++){
                if(nums[j] % nums[i] == 0 && dp.get(j).size() > sub_ans_size){
                    sub_ans_size = dp.get(j).size();
                    sub_ans_index = j;
                }
            }
            dp.get(i).add(nums[i]);
            if(sub_ans_index != -1) dp.get(i).addAll(dp.get(sub_ans_index));
            if(ans_size < dp.get(i).size()){ 
                ans_size = dp.get(i).size();
                ans_index = i;
            }
        }
        return dp.get(ans_index);
    }
}

