class Solution:
    def customSortString(self, order, s):
        Count = {}
        for c in order:
            Count[c] = 0
        for c in s:
            if c in Count:
                Count[c] += 1
        ans = ""
        for c in order:
            ans += Count[c] * c
        for c in s:
            if c not in Count:
                ans += c
        return ans

