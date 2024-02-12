from collections import Counter

class Solution:
    def majorityElement(self, nums):
        ele = nums[0]
        count = 1
        n = len(nums)
        for i in range(1, n):
            if count == 0:
                ele = nums[i]
                count += 1
            elif ele == nums[i]:
                count += 1
            else:
                count -= 1
        return ele


