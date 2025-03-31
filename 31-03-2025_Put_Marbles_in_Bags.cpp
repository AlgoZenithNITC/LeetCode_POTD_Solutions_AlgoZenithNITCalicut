class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
    if (k == 1) {
        return 0;
    }
    
    int n = weights.size();
    vector<long long> pairs;
    for (int i = 0; i < n - 1; ++i) {
        pairs.push_back(static_cast<long long>(weights[i]) + weights[i + 1]);
    }
    
    sort(pairs.begin(), pairs.end());
    long long min_score = accumulate(pairs.begin(), pairs.begin() + (k - 1), 0LL);
    long long max_score = accumulate(pairs.end() - (k - 1), pairs.end(), 0LL);
    
    return max_score - min_score;
}
};
