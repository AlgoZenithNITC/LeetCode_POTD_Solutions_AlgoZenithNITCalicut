//recursion
def f(ind, num, k):
    n = len(num)
    
    if ind == n: return 0
    len_ = 0
    maxi = float('-inf')
    maxAns = float('-inf')
    
    for j in range(ind, min(ind + k, n)):
        len_ += 1
        maxi = max(maxi, num[j])
        sum_ = len_ * maxi + f(j + 1, num, k)
        maxAns = max(maxAns, sum_)
    return maxAns

def maxSumAfterPartitioning(arr, k):
    return f(0, arr, k)

//********************************************************************************************************************************************************************************************************************
//memoization

class Solution:
    def f(self, ind, num, k, dp):
        n = len(num)
        
        if ind == n:
            return 0
        if dp[ind] != -1:
            return dp[ind]
        length = 0
        maxi = float('-inf')
        max_ans = float('-inf')
        
        for j in range(ind, min(ind + k, n)):
            length += 1
            maxi = max(maxi, num[j])
            sum_ = length * maxi + self.f(j + 1, num, k, dp)
            max_ans = max(max_ans, sum_)
        dp[ind] = max_ans
        return dp[ind]

    def max_sum_after_partitioning(self, arr, k):
        n = len(arr)
        dp = [-1] * n
        return self.f(0, arr, k, dp)
//******************************************************************************************************************************************************************************************************************

//Tabulation
class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        n = len(arr)
        dp = [0] * (n + 1)
        
        for ind in range(n - 1, -1, -1):
            length = 0
            maxi = float('-inf')
            maxAns = float('-inf')
            
            for j in range(ind, min(ind + k, n)):
                length += 1
                maxi = max(maxi, arr[j])
                sum_ = length * maxi + dp[j + 1]
                maxAns = max(maxAns, sum_)
            dp[ind] = maxAns
        return dp[0]


