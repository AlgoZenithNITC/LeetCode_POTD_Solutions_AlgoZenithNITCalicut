class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        min_freq = [float('inf')] * 26
        
        for word in words:
            freq = [0] * 26
            for c in word:
                freq[ord(c) - ord('a')] += 1
            min_freq = [min(min_freq[i], freq[i]) for i in range(26)]
        
        result = []
        for i in range(26):
            result.extend([chr(i + ord('a'))] * min_freq[i])
        
        return result

