class Solution(object):
    def constrainedSubsetSum(self, nums, k):
        n = len(nums)
        dp = nums[:]
        pq = []
        heapq.heappush(pq, (-nums[0], 0))
        ans = dp[0]
        for i in range(1, n):
            while pq and i - pq[0][1] > k:
                heapq.heappop(pq)
            dp[i] = max(dp[i], nums[i] - pq[0][0])
            heapq.heappush(pq, (-dp[i], i))
            ans = max(ans, dp[i])
        return ans
