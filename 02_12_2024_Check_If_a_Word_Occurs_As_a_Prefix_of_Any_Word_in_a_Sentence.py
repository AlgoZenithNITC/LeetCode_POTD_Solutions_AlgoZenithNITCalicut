class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split()
        n = len(searchWord)
        for index, word in enumerate(words):
            if searchWord == word[:n]:
                return index + 1
        return -1

