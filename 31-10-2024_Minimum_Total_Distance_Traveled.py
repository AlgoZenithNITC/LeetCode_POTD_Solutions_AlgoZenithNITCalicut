import sys
from typing import List

class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        n = len(robot)
        N = len(factory)
        
        # Sort robot and factory for consistency
        robot.sort()
        factory.sort()
        
        inf = int(1e15)
        dp = [[[inf] * 101 for _ in range(101)] for _ in range(101)]
        
        for i in range(n):
            for j in range(N):
                xR = robot[i]
                xF, cap = factory[j][0], factory[j][1]
                
                
                nottake = inf if j == 0 else dp[i][j - 1][0]
                dp[i][j][cap] = nottake
                
                for k in range(cap):
                
                    take = abs(xR - xF) if i == 0 else abs(xR - xF) + dp[i - 1][j][k + 1]
                    dp[i][j][k] = min(take, nottake)
        
        return dp[n - 1][N - 1][0]
