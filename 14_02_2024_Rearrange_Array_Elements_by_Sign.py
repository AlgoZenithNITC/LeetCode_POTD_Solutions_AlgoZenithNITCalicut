class Solution:
    def rearrangeArray(self, nums):
        l = len(nums)
        v = [0] * l
        k = 0
        for i in range(l):
            if nums[i] > 0:
                v[k] = nums[i]
                k += 2
        k = 1
        for i in range(l):
            if nums[i] < 0:
                v[k] = nums[i]
                k += 2
        return v

