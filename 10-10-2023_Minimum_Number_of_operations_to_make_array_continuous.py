class Solution:
    from bisect import bisect_right
    def minOperations(self, nums):
        n = len(nums)
        ans = n
        s = set(nums)
        unique_elements = sorted(list(s))
        size = len(unique_elements)
        for start in range(size):
            end_index = bisect_right(unique_elements, unique_elements[start] + n - 1, lo=start)
            ans = min(ans, n - (end_index - start))
        return ans
