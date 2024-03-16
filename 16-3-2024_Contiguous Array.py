from collections import defaultdict

class Solution:
    def findMaxLength(self, nums):
        n = len(nums)
        mp = defaultdict(int)
        sum = 0
        subArray_length = 0
        for i in range(n):
            sum += -1 if nums[i] == 0 else 1
            if sum == 0:
                subArray_length = max(subArray_length, i + 1)
            elif sum in mp:
                subArray_length = max(subArray_length, i - mp[sum])
            else:
                mp[sum] = i
        return subArray_length


