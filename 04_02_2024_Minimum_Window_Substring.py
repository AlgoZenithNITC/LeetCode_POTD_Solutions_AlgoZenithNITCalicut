from collections import Counter

class Solution:
    def minWindow(self, s, t):
        if t == "":
            return ""
        mpt = Counter(t)
        len_s = len(s)
        pr = (-1, -1)
        mps = Counter()
        have = 0
        need = len(mpt)
        j = 0
        for i in range(len(s)):
            mps[s[i]] += 1
            if s[i] in mpt and mps[s[i]] == mpt[s[i]]:
                have += 1
            while have == need:
                if i - j + 1 <= len_s:
                    pr = (j, i)
                    len_s = i - j + 1
                mps[s[j]] -= 1
                if s[j] in mpt and mps[s[j]] < mpt[s[j]]:
                    have -= 1
                j += 1
        if pr[1] == -1 or pr[0] == -1:
            return ""
        return s[pr[0]:pr[1]+1]

