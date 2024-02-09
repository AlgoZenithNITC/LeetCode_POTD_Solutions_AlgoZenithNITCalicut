from typing import List

class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        n = len(nums)
        nums.sort()
        dp = [[] for _ in range(n)]
        dp[n-1] = [nums[n-1]]
        ans_size = 1
        ans_index = n-1
        for i in range(n-2, -1, -1):
            sub_ans_size = 0
            sub_ans_index = -1
            for j in range(i+1, n):
                if nums[j] % nums[i] == 0 and len(dp[j]) > sub_ans_size:
                    sub_ans_size = len(dp[j])
                    sub_ans_index = j
            dp[i] = [nums[i]]
            if sub_ans_index != -1:
                dp[i].extend(dp[sub_ans_index])
            if ans_size < len(dp[i]):
                ans_size = len(dp[i])
                ans_index = i
        return dp[ans_index]

