class Solution:
    def canPartition(self, nums):
        total = sum(nums)
        if total % 2 != 0:
            return False

        target = total // 2
        n = len(nums)

        # Initialize memo table with -1 (meaning uncomputed)
        dp = [[-1] * (target + 1) for _ in range(n)]

        def solve(index, curr_sum):
            if curr_sum == 0:
                return True
            if index >= n or curr_sum < 0:
                return False
            if dp[index][curr_sum] != -1:
                return dp[index][curr_sum]

            # Try including or excluding current element
            include = solve(index + 1, curr_sum - nums[index])
            exclude = solve(index + 1, curr_sum)

            dp[index][curr_sum] = include or exclude
            return dp[index][curr_sum]

        return solve(0, target)
       
