class Solution(object):
    def isPowerOfFour(self, n):
        return n > 0 and (n & (n - 1)) == 0 and (n & 0x55555555) != 0
