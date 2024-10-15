class Solution:
    def minimumSteps(self, s: str) -> int:
        bbc = 0
        ans = 0
        for i in s:
            if i == '0':
                ans += bbc
            else:
                bbc += 1
        
        return ans
