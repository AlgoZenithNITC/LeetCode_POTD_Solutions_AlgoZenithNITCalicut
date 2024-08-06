class Solution:
    def minimumPushes(self, word: str) -> int:
        letter_freq = [0] * 26
        for c in word:
            letter_freq[ord(c) - ord('a')] += 1
        
        letter_freq.sort(reverse=True)
        
        total_presses = 0
        for i in range(26):
            if letter_freq[i] == 0:
                break
            total_presses += (i // 8 + 1) * letter_freq[i]
        
        return total_presses

