class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        self.n = len(s)
        self.ans = []
        self.solve(0, s, [])
        return self.ans

    def is_palin(self, a, b, s):
        i, j = a, b
        while i <= j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True

    def solve(self, a, s, temp):
        if a == self.n:
            self.ans.append(temp[:])
            return

        for i in range(a, self.n):
            if self.is_palin(a, i, s):
                temp.append(s[a:i+1])
                self.solve(i + 1, s, temp)
                temp.pop()
