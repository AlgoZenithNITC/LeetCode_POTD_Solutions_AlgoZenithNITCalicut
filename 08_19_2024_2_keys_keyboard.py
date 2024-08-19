class Solution:
    def solve(self, n, s, c):
        if s == n:
            return 0
        if s > n:
            return float('inf')

        paste = 1 + self.solve(n, s + c, c)

        copy = float('inf')
        if c < s:
            copy = 1 + self.solve(n, s, s)

        return min(paste, copy)

    def minSteps(self, n):
        if n == 1:
            return 0
        return 1 + self.solve(n, 1, 1)
