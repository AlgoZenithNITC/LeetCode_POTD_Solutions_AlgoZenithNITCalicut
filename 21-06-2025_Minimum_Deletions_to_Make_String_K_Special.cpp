class Solution {
public:
  int minDeletionsToMakeKSpecial(string word, int k) {
    unordered_map<char, int> freqMap;
    for (char c : word) {
        freqMap[c]++;
    }

    vector<int> freqs;
    for (auto& p : freqMap) {
        freqs.push_back(p.second);
    }
    sort(freqs.begin(), freqs.end());

    int n = freqs.size();
    vector<int> prefixSum(n + 1, 0);
    for (int i = 0; i < n; ++i) {
        prefixSum[i + 1] = prefixSum[i] + freqs[i];
    }

    int minDeletions = INT_MAX;

    for (int i = 0; i < n; ++i) {
        int minFreq = freqs[i];
        int maxAllowed = minFreq + k;
        
        int r = upper_bound(freqs.begin(), freqs.end(), maxAllowed) - freqs.begin();

        int deletionsLeft = prefixSum[i];
        int deletionsRight = prefixSum[n] - prefixSum[r] - maxAllowed * (n - r);

        minDeletions = min(minDeletions, deletionsLeft + deletionsRight);
    }

    return minDeletions;
  }  
}

