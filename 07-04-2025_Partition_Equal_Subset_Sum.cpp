class Solution {
public:
    vector<vector<int>> dp;

    bool solve(int index, vector<int>& nums, int target) {
        if (target == 0) return true;
        if (index >= nums.size() || target < 0) return false;

        if (dp[index][target] != -1) return dp[index][target];

        bool incl = solve(index + 1, nums, target - nums[index]);
        bool excl = solve(index + 1, nums, target);

        return dp[index][target] = incl || excl;
    }

    bool canPartition(vector<int>& nums) {
        int total = accumulate(nums.begin(), nums.end(), 0);
        if (total % 2 != 0) return false;
        int target = total / 2;

        dp = vector<vector<int>>(nums.size(), vector<int>(target + 1, -1));
        return solve(0, nums, target);
    }




};
