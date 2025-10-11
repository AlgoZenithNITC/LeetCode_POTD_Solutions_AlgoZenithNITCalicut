class Solution {
public:
    long long maximumTotalDamage(vector<int>& power) {
        unordered_map<long long, long long> total;
        for (long long x : power) total[x] += x;
        
        vector<long long> vals;
        for (auto &p : total) vals.push_back(p.first);
        sort(vals.begin(), vals.end());
        
        int n = vals.size();
        vector<long long> dp(n, 0);
        dp[0] = total[vals[0]];
        
        for (int i = 1; i < n; ++i) {
            long long take = total[vals[i]];
            int j = i - 1;
            while (j >= 0 && vals[j] >= vals[i] - 2) j--;
            if (j >= 0) take += dp[j];
            dp[i] = max(dp[i-1], take);
        }
        return dp[n-1];
    }
};
