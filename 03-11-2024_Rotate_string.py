class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False

        s = s + s
        i, j = 0, 0
        n = len(goal)

        while i < 2 * n and j < n:
            if s[i] == goal[j]:
                i += 1
                j += 1
            else:
                i = i - j + 1
                j = 0
            
            if j == n:
                return True

        return False
