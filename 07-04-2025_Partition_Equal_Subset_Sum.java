class Solution {
    int[][] dp;

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false; // If total sum is odd, can't partition
        int target = total / 2;
        int n = nums.length;

        dp = new int[n][target + 1]; // 0 = uncomputed, 1 = true, -1 = false

        return solve(0, target, nums);
    }

    private boolean solve(int index, int target, int[] nums) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        if (dp[index][target] != 0) {
            return dp[index][target] == 1;
        }

        boolean include = solve(index + 1, target - nums[index], nums);
        boolean exclude = solve(index + 1, target, nums);

        dp[index][target] = (include || exclude) ? 1 : -1;
        return dp[index][target] == 1;
    }
}
