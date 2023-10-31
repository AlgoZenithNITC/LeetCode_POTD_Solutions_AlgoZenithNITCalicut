class Solution(object):
    def findArray(self, pref):
        n = len(pref)
        result = [0]*n
        result[0] = pref[0]
        for i in range(1, n):
            result[i] = pref[i - 1]^pref[i]
        return result
