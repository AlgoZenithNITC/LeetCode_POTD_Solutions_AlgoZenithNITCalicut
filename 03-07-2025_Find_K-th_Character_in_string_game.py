class Solution:
    def kthCharacter(self, k: int) -> str:
        s = "ab"
        while len(s) < k:
            temp = ''
            for ch in s:
                if ch == 'z':
                    temp += 'a'
                else:
                    temp += chr(ord(ch) + 1)
            s += temp
        return s[k - 1]
