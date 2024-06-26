from typing import List

class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        count = [0] * 26
        letters_count = [0] * 26
        for c in letters:
            count[ord(c) - ord('a')] += 1
        
        ans = 0
        
        def backtracking(pos: int, temp: int) -> None:
            nonlocal ans
            for i in range(26):
                if letters_count[i] > count[i]:
                    return
            ans = max(ans, temp)
            for i in range(pos, len(words)):
                for c in words[i]:
                    letters_count[ord(c) - ord('a')] += 1
                    temp += score[ord(c) - ord('a')]
                backtracking(i + 1, temp)
                for c in words[i]:
                    letters_count[ord(c) - ord('a')] -= 1
                    temp -= score[ord(c) - ord('a')]
        
        backtracking(0, 0)
        return ans

