class Solution {
    public int maximumDifference(int[] nums) {
        int smallest = nums[0];
        int ans = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
            if (nums[i] - smallest > ans) {
                ans = nums[i] - smallest;
            }
        }

        return ans > 0 ? ans : -1;
    }
}