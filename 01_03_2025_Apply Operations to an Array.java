import java.util.*;

class Solution {
    public int[] applyOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] == 0) {
                count++;
            }
        }
        if (nums[nums.length - 1] == 0) {
            count++;
        }

        int[] ans = new int[nums.length];
        int index = 0;
        
        // Add non-zero elements first
        for (int num : nums) {
            if (num != 0) {
                ans[index++] = num;
            }
        }

        // The remaining spaces are already zero-initialized
        return ans;
    }
}
