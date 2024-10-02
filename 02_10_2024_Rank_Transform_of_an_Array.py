from collections import defaultdict

class Solution:
    def arrayRankTransform(self, arr):
        ans = []
        mpp = defaultdict(int)
        for i in arr:
            mpp[i] += 1
        m = 1
        for key in sorted(mpp.keys()):
            mpp[key] = m
            m += 1
        for i in arr:
            ans.append(mpp[i])
        return ans

