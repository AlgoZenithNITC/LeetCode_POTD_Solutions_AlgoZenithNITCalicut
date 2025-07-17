class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 1;

        // Try all possible values of (sub[i] + sub[i+1]) % k
        for (int val = 0; val < k; val++) {
            int[] dp = new int[k];  // dp[i] = max length of subsequence ending with num % k == i

            for (int num : nums) {
                int rem = num % k;
                int requiredRem = (k + val - rem) % k;
                dp[rem] = Math.max(dp[rem], dp[requiredRem] + 1);
                ans = Math.max(ans, dp[rem]);
            }
        }

        return ans;
    }
    }
