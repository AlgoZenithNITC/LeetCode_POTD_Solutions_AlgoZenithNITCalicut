class Solution {
    private int backtrack(int[] nums, int numSize, int target, int x, int sum, int ans) {
        if (x == numSize) {
            if (sum == target) {
                return ans + 1;
            } else {
                return ans;
            }
        } else {
            ans = backtrack(nums, numSize, target, x + 1, sum + nums[x], ans);
            ans = backtrack(nums, numSize, target, x + 1, sum - nums[x], ans);
        }
        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, nums.length, target, 0, 0, 0);
    }
}
