class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, int> index;
        unordered_map<int, int> dp;
        int max_len = 0;

        // Store index of each element in arr
        for (int i = 0; i < n; i++) {
            index[arr[i]] = i;
        }

        // Iterate over all pairs (j, k) to find valid (i, j, k) triplets
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.count(arr[k] - arr[j]) ? index[arr[k] - arr[j]] : -1;
                if (i >= 0 && i < j) {
                    int key = j * n + k;  // Unique key for dp
                    int prev_key = i * n + j;
                    dp[key] = (dp.count(prev_key) ? dp[prev_key] : 2) + 1;
                    max_len = max(max_len, dp[key]);
                }
            }
        }
        
        return max_len >= 3 ? max_len : 0;
    }
};
