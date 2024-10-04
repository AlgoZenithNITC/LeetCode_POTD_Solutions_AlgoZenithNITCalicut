from collections import defaultdict

class Solution:
    def dividePlayers(self, skill: list[int]) -> int:
        mp = defaultdict(int)
        mini = float('inf')
        maxi = float('-inf')
        
        for i in skill:
            mp[i] += 1
            mini = min(mini, i)
            maxi = max(maxi, i)
        
        ans = 0
        total_sum = mini + maxi
        n = len(skill)
        
        for i in list(mp.keys()):
            if mp[i] == 0:
                continue
            
            rem = total_sum - i
            if rem not in mp or mp[rem] != mp[i]:
                return -1
            else:
                if rem == i:
                    mp[i] //= 2
                ans += mp[i] * rem * i
                mp[rem] = 0
        
        return ans
