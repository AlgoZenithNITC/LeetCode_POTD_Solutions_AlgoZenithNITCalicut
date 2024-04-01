class Solution:
    def lengthOfLastWord(self, s):
        count = 0
        for i in range(len(s)-1, -1, -1):
            if count == 0 and s[i] == ' ':
                continue
            elif count != 0 and s[i] == ' ':
                return count
            elif s[i] != ' ':
                count += 1
        return count

