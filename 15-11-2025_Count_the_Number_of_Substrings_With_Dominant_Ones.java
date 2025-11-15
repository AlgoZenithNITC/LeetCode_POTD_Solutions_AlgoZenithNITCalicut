class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pref = new int[n + 1];
        ArrayList<Integer> zeroPos = new ArrayList<>();

        // prefix sum of ones + zero positions
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + (s.charAt(i) == '1' ? 1 : 0);
            if (s.charAt(i) == '0') zeroPos.add(i);
        }

        int Z = zeroPos.size();
        int K = (int) Math.sqrt(n) + 3;
        int ans = 0;

        // Case z = 0 → substrings of consecutive 1's
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }
        ans += cnt * (cnt + 1) / 2;

        // z = 1..K zeros
        for (int z = 1; z <= K; z++) {
            if (z > Z) break;

            for (int j = z - 1; j < Z; j++) {

                int leftZero  = (j - z < 0 ? -1 : zeroPos.get(j - z));
                int firstZero = zeroPos.get(j - z + 1);
                int lastZero  = zeroPos.get(j);
                int rightZero = (j + 1 < Z ? zeroPos.get(j + 1) : n);

                // L ∈ [leftZero+1 .. firstZero]
                // R ∈ [lastZero .. rightZero-1]
                for (int L = leftZero + 1; L <= firstZero; L++) {

                    int lo = lastZero, hi = rightZero - 1;
                    int best = rightZero;

                    // Binary search for smallest R
                    while (lo <= hi) {
                        int mid = (lo + hi) / 2;
                        int ones = pref[mid + 1] - pref[L];
                        if (ones >= z * z) {
                            best = mid;
                            hi = mid - 1;
                        } else {
                            lo = mid + 1;
                        }
                    }

                    if (best < rightZero) {
                        ans += (rightZero - best);
                    }
                }
            }
        }

        return ans;
    }
}
