class Solution(object):
  def numberOfArithmeticSlices(self, nums):     
    n = len(nums)
    result = 0
    mp = [{} for _ in range(n)]
    for i in range(n):
        for j in range(i):
            diff = nums[i] - nums[j]
            count_at_j = mp[j].get(diff, 0)
            mp[i][diff] = mp[i].get(diff, 0) + count_at_j + 1
            result += count_at_j
    return result
