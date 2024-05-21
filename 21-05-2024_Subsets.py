class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        if not nums:
            return [[]]
        n = len(nums)
        for m in range(2 ** n):
            sub = []
            for i in range(n):
                if m & (1 << i):
                    sub.append(nums[i])
            ans.append(sub)
        ans.append(nums)
        return ans

