class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        mp = {}
        n = len(nums)
        i, j, ans, flag = 0, 0, 0, 0
        while j < n:
            mp[nums[j]] = mp.get(nums[j], 0) + 1
            if mp[nums[j]] > k:
                flag = 1
            while flag == 1 and i <= j:
                ans = max(ans, j - i)
                mp[nums[i]] -= 1
                if mp[nums[j]] == k:
                    flag = 0
                i += 1
            j += 1
        ans = max(ans, j - i)
        return ans
