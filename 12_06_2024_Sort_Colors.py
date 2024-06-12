class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        mp = {}
        for i in nums:
            if i in mp:
                mp[i] += 1
            else:
                mp[i] = 1
        
        idx = 0
        for key in range(3):  # We know the keys are 0, 1, 2
            count = mp.get(key, 0)  # Use get to handle missing keys
            for _ in range(count):
                nums[idx] = key
                idx += 1
