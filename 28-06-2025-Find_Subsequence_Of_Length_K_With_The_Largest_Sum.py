from collections import Counter
from typing import List

class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        # Sort and get top k values
        copy = sorted(nums, reverse=True)
        count = Counter(copy[:k])  # counts top k elements

        ans = []
        for num in nums:
            if count[num] > 0:
                ans.append(num)
                count[num] -= 1
                if len(ans) == k:
                    break
        return ans
