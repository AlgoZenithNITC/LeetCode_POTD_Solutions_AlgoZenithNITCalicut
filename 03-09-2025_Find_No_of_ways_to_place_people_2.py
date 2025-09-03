from typing import List

class Solution:
    def numberOfPairs(self, nums: List[List[int]]) -> int:
        # Sort by x ascending, if tie then y descending
        nums.sort(key=lambda x: (x[0], -x[1]))
        
        n = len(nums)
        count = 0

        for i in range(n):
            maxi = float("-inf")
            for j in range(i + 1, n):
                if nums[j][1] > nums[i][1]:
                    continue
                if nums[j][1] > maxi:
                    count += 1
                    maxi = nums[j][1]
        return count
