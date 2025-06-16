class Solution:
    def maximumDifference(self, nums):
        smallest = nums[0]
        ans = -1
        
        for i in range(1, len(nums)):
            if nums[i] < smallest:
                smallest = nums[i]
            if nums[i] - smallest > ans:
                ans = nums[i] - smallest
        
        return ans if ans > 0 else -1