class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        sLength = len(s)
        tLength = len(t)
        sIndex = 0
        tIndex = 0
        
        while tIndex < tLength and sIndex < sLength:
            if s[sIndex] == t[tIndex]:
                tIndex += 1
            sIndex += 1
        
        return tLength - tIndex
