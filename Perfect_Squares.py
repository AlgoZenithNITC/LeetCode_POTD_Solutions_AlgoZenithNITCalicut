class Solution:
    def numSquares(self, n):
        dp = [0]+([float('inf')]*n)
        pows = [pow(j, 2) for j in range(int(math.sqrt(n)+1))]
        sqrt = [int(math.sqrt(i)) for i in range(n+1)]
        for i in range(1, n+1):
            dp[i] = 1 + min(
                dp[i-pows[j]]
                for j in range(sqrt[i]+1))
        return dp[-1]
