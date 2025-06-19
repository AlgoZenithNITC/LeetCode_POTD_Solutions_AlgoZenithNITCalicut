class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
         nums.sort()
         i = 0
         j = 0
         res = 0

         while j < len(nums):
            if nums[j] - nums[i] <= k:
                j += 1
            else:
                res += 1
                i = j

         return res + 1  # count the final valid group
