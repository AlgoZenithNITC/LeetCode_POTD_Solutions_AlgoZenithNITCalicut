class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        n = len(nums)
        flipped = 0
        res = 0
        is_flipped = [0] * n

        for i in range(n):
            if i >= k:
                flipped ^= is_flipped[i - k]
            if flipped == nums[i]:
                if i + k > n:
                    return -1
                is_flipped[i] = 1
                flipped ^= 1
                res += 1

        return res

