class Solution(object):
    def countHomogenous(self, s):
        mod = int(1e9) + 7
        prev = 1
        ans = prev
        for i in range(1, len(s)):
            curr = 1
            if s[i] == s[i - 1]:
                curr += prev
            prev = curr
            ans += curr
        return ans % mod
