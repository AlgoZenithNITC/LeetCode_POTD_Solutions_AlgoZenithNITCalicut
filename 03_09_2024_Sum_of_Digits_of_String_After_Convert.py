class Solution:
    def getLucky(self, s: str, k: int) -> int:
        if s == "":
            return 0

        num = ""
        for c in s:
            n = ord(c) - ord('a') + 1
            num += str(n)
        
        ans = 0
        while k > 0:
            ans = 0
            for digit in num:
                ans += int(digit)
            num = str(ans)
            k -= 1
        
        return ans

