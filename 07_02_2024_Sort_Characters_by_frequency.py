from collections import Counter

class Solution:
    def frequencySort(self, s):
        count = Counter(s)
        sorted_chars = sorted(count.items(), key=lambda x: x[1], reverse=True)
        ans = ""
        for char, freq in sorted_chars:
            ans += char * freq
        return ans

