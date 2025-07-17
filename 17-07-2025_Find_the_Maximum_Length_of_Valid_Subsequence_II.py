class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        ans = 1

    # Try all possible values of (sub[i] + sub[i+1]) % k
        for val in range(k):
            dp = [0] * k  # dp[i] = max length of subsequence ending with num % k == i

            for num in nums:
                rem = num % k
                required_rem = (k + val - rem) % k
                dp[rem] = max(dp[rem], dp[required_rem] + 1)
                ans = max(ans, dp[rem])

        return ans        
