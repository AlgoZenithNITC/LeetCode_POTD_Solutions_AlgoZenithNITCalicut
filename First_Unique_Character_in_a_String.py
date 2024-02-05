from collections import Counter
class Solution(object):
    def firstUniqChar(self, s):
        m = Counter(s)
        for i, char in enumerate(s):
            if m[char] == 1:
                return i
        return -1
