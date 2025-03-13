from typing import List

class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        left, right, answer = 0, len(queries), -1

        def canMakeZero(mid: int) -> bool:
            diff = [0] * (n + 1)

            # Apply the first `mid` queries using the difference array
            for i in range(mid):
                l, r, val = queries[i]
                diff[l] -= val
                diff[r + 1] += val

            # Apply the difference array to determine the actual decrements
            applied = [0] * n
            curr_decrement = 0
            for i in range(n):
                curr_decrement += diff[i]
                applied[i] = curr_decrement

            # Check if we can reduce all nums[i] to zero
            for i in range(n):
                if nums[i] + applied[i] > 0:
                    return False
            return True

        # Binary search for the minimum `k`
        while left <= right:
            mid = left + (right - left) // 2
            if canMakeZero(mid):
                answer = mid
                right = mid - 1  # Try to minimize `k`
            else:
                left = mid + 1  # Increase `k`

        return answer
