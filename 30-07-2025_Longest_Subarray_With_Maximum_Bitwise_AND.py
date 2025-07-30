class Solution:
    def longestSubarray(self, nums):
        maxi = max(nums)
        maxlen = 0
        len_count = 0
        
        for num in nums:
            if num == maxi:
                len_count += 1
                maxlen = max(maxlen, len_count)
            else:
                len_count = 0
        
        return maxlen
