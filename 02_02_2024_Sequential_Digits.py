from itertools import permutations

class Solution:
    def sequentialDigits(self, low, high):
        s = "123456789"
        ans = []
        
        for i in range(len(s)):
            for j in range(i, len(s)):
                num = int(s[i:j+1])
                if low <= num <= high:
                    ans.append(num)
        
        ans.sort()
        return ans

