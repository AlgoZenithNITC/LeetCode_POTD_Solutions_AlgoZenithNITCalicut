class Solution:
    def prefixCount(self, words, pref):
        count = 0
        len_pref = len(pref)
        for word in words:
            if len_pref <= len(word):
                sub = word[:len_pref]
                if pref == sub:
                    count += 1
        return count
