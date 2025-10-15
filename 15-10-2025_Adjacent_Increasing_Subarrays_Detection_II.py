class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = 1
        prev = 0
        max_val = 0

        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                cnt += 1
            else:
                prev = cnt
                cnt = 1

            temp = prev
            if cnt < prev:
                temp = cnt

            if temp > max_val:
                max_val = temp

            if cnt // 2 > max_val:
                max_val = cnt // 2

        return max_val
