from typing import List

class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        left, right = 0, n

        while left <= right:
            mid = left + (right - left) // 2
            count = sum(num >= mid for num in nums)

            if count == mid:
                return mid
            elif count > mid:
                left = mid + 1
            else:
                right = mid - 1

        return -1
