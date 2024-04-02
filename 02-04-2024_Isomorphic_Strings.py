class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        S = [0] * 200
        T = [0] * 200

        length = len(s)
        if length != len(t):
            return False
        for i in range(length):
            if S[ord(s[i])] != T[ord(t[i])]:
                return False
            S[ord(s[i])] = i + 1
            T[ord(t[i])] = i + 1
        return True
