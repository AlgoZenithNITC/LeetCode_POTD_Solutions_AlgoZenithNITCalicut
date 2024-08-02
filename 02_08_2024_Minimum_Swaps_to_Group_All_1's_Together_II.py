class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        k = sum(nums)
        n = len(nums)
        cnt = sum(nums[:k])
        mx = cnt
        for i in range(k, n + k):
            cnt += nums[i % n] - nums[(i - k + n) % n]
            mx = max(mx, cnt)
        return k - mx

