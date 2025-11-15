class Solution {
public:
   
    int numberOfSubstrings(string s) {
        int n = s.size();
        vector<int> pref(n+1, 0);
        vector<int> zeroPos;

        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + (s[i]=='1');
            if (s[i]=='0') zeroPos.push_back(i);
        }

        int Z = zeroPos.size();
        int K = sqrt(n) + 2;
        long long ans = 0;

        // Case z = 0 (all 1s substrings)
        // count all consecutive 1-runs
        long long cnt = 0;
        for (char c : s) {
            if (c=='1') cnt++;
            else { ans += cnt*(cnt+1)/2; cnt = 0; }
        }
        ans += cnt*(cnt+1)/2;

        // z = 1..K
        for (int z = 1; z <= K; z++) {
            if (z > Z) break;

            for (int j = z-1; j < Z; j++) {
                // substring has exactly z zeros from zeroPos[j-z+1] .. zeroPos[j]
                int leftZero = (j - z < 0 ? -1 : zeroPos[j - z]);
                int firstZero = zeroPos[j - z + 1]; 
                int lastZero  = zeroPos[j];
                int rightZero = (j+1 < Z ? zeroPos[j+1] : n);

                for (int L = leftZero + 1; L <= firstZero; L++) {
                    // find smallest R
                    int lo = lastZero, hi = rightZero - 1, best = hi+1;
                    while (lo <= hi) {
                        int mid = (lo + hi) / 2;
                        int ones = pref[mid+1] - pref[L];
                        if (ones >= z*z) {
                            best = mid;
                            hi = mid - 1;
                        } else lo = mid + 1;
                    }
                    if (best <= rightZero - 1)
                        ans += (rightZero - best);
                }
            }
        }

        return ans;
    }
};
