class Solution:
    def maxWidthRamp(self, nums):
        n = len(nums)
        s = []
        
        for i in range(n):
            if not s or nums[s[-1]] > nums[i]:
                s.append(i)
        
        maxWidth = 0
        
        for j in range(n - 1, -1, -1):
            while s and nums[s[-1]] <= nums[j]:
                maxWidth = max(maxWidth, j - s.pop())
        
        return maxWidth

