class Solution {
public:
    
    int maximumLength(vector<int>& nums, int k) {
        int ans = 1;
        for (int val = 0; val < k; ++val) {
            vector<int> dp(k, 0);
        for (int num : nums) {
            int rem = num % k;
            int required_rem = (k + val - rem) % k;
            dp[rem] = max(dp[rem], dp[required_rem] + 1);
            ans = max(ans, dp[rem]);
        }
    }

    return ans;
}
};
