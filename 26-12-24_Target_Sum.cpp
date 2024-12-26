class Solution {
public:
    int backtrack(vector<int>& nums, int numSize, int target, int x, int sum, int ans) {
        if (x == numSize) {
            return (sum == target) ? ans + 1 : ans;
        } else {
            ans = backtrack(nums, numSize, target, x + 1, sum + nums[x], ans);
            ans = backtrack(nums, numSize, target, x + 1, sum - nums[x], ans);
        }
        return ans;
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        return backtrack(nums, nums.size(), target, 0, 0, 0);
    }
};
