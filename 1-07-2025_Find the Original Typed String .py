class Solution:
    def possibleStringCount(self, word: str) -> int:
        cnt = 0
        for i in range(len(word) - 1):
            if word[i] == word[i + 1]:
                cnt += 1
        return cnt + 1