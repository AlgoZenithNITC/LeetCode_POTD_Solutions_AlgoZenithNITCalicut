
class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        
        max_diff = abs(nums[-1] - nums[0])
        
        for i in range(len(nums) - 1):
            current_diff = abs(nums[i] - nums[i + 1])
            if current_diff > max_diff:
                max_diff = current_diff
                
        return max_diff