class Solution:
    def stoneGameII(self, piles):
        n = len(piles)
        
        dp = [[0] * (n + 1) for _ in range(n)]
        suffixSum = [0] * n
        suffixSum[n - 1] = piles[n - 1]
        
        for i in range(n - 2, -1, -1):
            suffixSum[i] = suffixSum[i + 1] + piles[i]
        
        for i in range(n - 1, -1, -1):
            for m in range(1, n + 1):
                if i + 2 * m >= n:
                    dp[i][m] = suffixSum[i]
                else:
                    for x in range(1, 2 * m + 1):
                        dp[i][m] = max(dp[i][m], suffixSum[i] - dp[i + x][max(m, x)])
        
        return dp[0][1]

