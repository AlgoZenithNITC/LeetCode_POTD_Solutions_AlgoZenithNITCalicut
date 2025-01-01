class Solution:
    def count1(self, s, j):
        c = 0
        for i in range(j + 1):
            if s[i] == '0':
                c += 1
        return c
    
    def count2(self, s, j):
        c = 0
        for i in range(j, len(s)):
            if s[i] == '1':
                c += 1
        return c
    
    def maxScore(self, s):
        max_score = 0
        for i in range(len(s) - 1):
            score = self.count1(s, i) + self.count2(s, i + 1)
            max_score = max(max_score, score)
        return max_score