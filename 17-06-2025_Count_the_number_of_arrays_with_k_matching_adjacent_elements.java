class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact, invFact;

    long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    void precomputeFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return (((fact[n] * invFact[k]) % MOD) * invFact[n - k]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n);
        long ways = comb(n - 1, k) * modPow(m - 1, n - 1 - k) % MOD;
        ways = ways * m % MOD;
        return (int) ways;
    }
}
