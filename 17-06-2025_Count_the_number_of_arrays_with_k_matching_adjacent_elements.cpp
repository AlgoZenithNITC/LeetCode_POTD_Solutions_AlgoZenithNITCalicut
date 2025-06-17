class Solution {
public:
    const int MOD = 1e9 + 7;
    vector<long long> fact, invFact;

    long long modPow(long long base, long long exp) {
        long long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp /= 2;
        }
        return result;
    }

    void precomputeFactorials(int n) {
        fact.resize(n + 1);
        invFact.resize(n + 1);
        fact[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; --i) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    long long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n); // since max needed is n-1
        long long ways = comb(n - 1, k) * modPow(m - 1, n - 1 - k) % MOD;
        ways = ways * m % MOD; // multiply by m for the first element
        return ways;
    }
};
