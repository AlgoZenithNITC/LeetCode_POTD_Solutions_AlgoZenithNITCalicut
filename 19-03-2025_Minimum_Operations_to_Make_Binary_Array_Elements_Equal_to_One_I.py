from typing import List

class Solution:
    def flip(self, i: int, nums: List[int]) -> None:
        for j in range(i, i + 3):
            nums[j] = 0 if nums[j] else 1
    
    def minOperations(self, nums: List[int]) -> int:
        zero_count = sum(1 for num in nums if num == 0)
        if not zero_count:
            return 0
        
        flips = 0
        n = len(nums)
        for i in range(n - 2):
            if nums[i] == 0:
                self.flip(i, nums)
                flips += 1
        
        zero_count = sum(1 for num in nums if num == 0)
        return flips if zero_count == 0 else -1
