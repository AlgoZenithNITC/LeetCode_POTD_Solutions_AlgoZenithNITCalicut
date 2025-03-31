class Solution:

     def maxPartitions(self, s: str) -> int:
        n = len(s)
        last_index = {ch: i for i, ch in enumerate(s)}
        ans = []
        
        farthest = 0
        left = 0
        for i, ch in enumerate(s):
            farthest = max(farthest, last_index[ch])
            if i == farthest:
                ans.append(farthest - left + 1)
                left = i + 1
        
        return len(ans)
