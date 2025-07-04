class Solution:
    def kthCharacter(self, k: int, operations: list[int]) -> str:
        a = 1  # current length of word
        n = 0  # number of operations needed to reach length ≥ k

        while k > a:
            a *= 2
            n += 1

        m = 0  # count of type-1 (shift) operations that affect the k-th character

        while n > 0 and k > 1:
            if a // 2 < k:
                a //= 2
                k -= a
                if operations[n - 1] == 1:
                    m += 1
            else:
                a //= 2
            n -= 1

        return chr(ord('a') + (m % 26))
