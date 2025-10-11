class Solution:
    def maximumTotalDamage(self, power: list[int]) -> int:
        # Step 1: total damage for each unique value
        total = Counter()
        for p in power:
            total[p] += p
        
        # Step 2: sort unique damage values
        vals = sorted(total.keys())
        n = len(vals)
        
        # Step 3: DP array
        dp = [0] * n
        dp[0] = total[vals[0]]
        
        for i in range(1, n):
            take = total[vals[i]]
            
            # find rightmost index j such that vals[j] <= vals[i] - 3
            j = bisect.bisect_right(vals, vals[i] - 3) - 1
            if j >= 0:
                take += dp[j]
            
            dp[i] = max(dp[i-1], take)
        
        return dp[-1]

        
