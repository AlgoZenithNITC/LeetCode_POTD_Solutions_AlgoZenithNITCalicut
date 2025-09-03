import java.util.*;

class Solution {
    public int numberOfPairs(int[][] nums) {
        // Sort by x ascending, if tie then y descending
        Arrays.sort(nums, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int maxi = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (nums[j][1] > nums[i][1]) continue;
                if (nums[j][1] > maxi) {
                    count++;
                    maxi = nums[j][1];
                }
            }
        }
        return count;
    }
}
