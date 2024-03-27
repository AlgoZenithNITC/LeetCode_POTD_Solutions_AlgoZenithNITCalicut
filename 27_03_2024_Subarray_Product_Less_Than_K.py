class Solution:
    def numSubarrayProductLessThanK(self, nums, k):
        currProd = 1
        left = 0
        right = 0
        leng = len(nums)
        subArrCnt = 0
        while right < leng:
            currProd *= nums[right]
            while currProd >= k and left <= right:
                currProd /= nums[left]
                left += 1
            if left <= right:
                subArrCnt += right - left + 1
            right += 1
        return subArrCnt

