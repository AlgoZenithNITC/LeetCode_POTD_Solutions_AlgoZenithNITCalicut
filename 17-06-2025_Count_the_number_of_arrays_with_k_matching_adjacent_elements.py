class Solution:
    MOD = 10**9 + 7

    def mod_pow(self, base: int, exp: int) -> int:
        result = 1
        while exp > 0:
            if exp % 2 == 1:
                result = result * base % self.MOD
            base = base * base % self.MOD
            exp //= 2
        return result

    def precompute_factorials(self, n: int):
        self.fact = [1] * (n + 1)
        self.inv_fact = [1] * (n + 1)
        for i in range(1, n + 1):
            self.fact[i] = self.fact[i - 1] * i % self.MOD
        self.inv_fact[n] = self.mod_pow(self.fact[n], self.MOD - 2)
        for i in range(n - 1, -1, -1):
            self.inv_fact[i] = self.inv_fact[i + 1] * (i + 1) % self.MOD

    def comb(self, n: int, k: int) -> int:
        if k < 0 or k > n:
            return 0
        return self.fact[n] * self.inv_fact[k] % self.MOD * self.inv_fact[n - k] % self.MOD

    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        self.precompute_factorials(n)
        ways = self.comb(n - 1, k) * self.mod_pow(m - 1, n - 1 - k) % self.MOD
        ways = ways * m % self.MOD
        return ways
