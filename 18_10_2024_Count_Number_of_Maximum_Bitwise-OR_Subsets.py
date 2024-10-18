class Solution:
    def solve(self, i, ors, maxi, nums):
        if i >= len(nums):
            return 1 if ors == maxi else 0

        cnt = 0
        cnt += self.solve(i + 1, ors | nums[i], maxi, nums)
        cnt += self.solve(i + 1, ors, maxi, nums)

        return cnt

    def countMaxOrSubsets(self, nums):
        maxi = 0
        
        for it in nums:
            maxi |= it

        return self.solve(0, 0, maxi, nums)

