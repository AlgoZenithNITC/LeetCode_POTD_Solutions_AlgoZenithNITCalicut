import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> divideArray(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new ArrayList<>();
            }
            ans.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
        }
        return ans;
    }
}