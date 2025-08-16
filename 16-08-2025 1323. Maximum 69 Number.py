class Solution(object):
    def maximum69Number(self, num):
        s = list(str(num))
        for i in xrange(len(s)):
            if s[i] == '6':
                s[i] = '9'
                break
        return int("".join(s))
