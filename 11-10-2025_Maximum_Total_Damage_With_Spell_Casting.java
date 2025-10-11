class Solution {
    public long maximumTotalDamage(int[] power) {
         Map<Long, Long> total = new HashMap<>();
        for (int p : power) {
            total.put((long)p, total.getOrDefault((long)p, 0L) + p);
        }

        // Step 2: Sort unique damage values
        List<Long> vals = new ArrayList<>(total.keySet());
        Collections.sort(vals);
        int n = vals.size();

        // Step 3: DP array
        long[] dp = new long[n];
        dp[0] = total.get(vals.get(0));

        for (int i = 1; i < n; i++) {
            long take = total.get(vals.get(i));
            
            // find the rightmost j such that vals[j] <= vals[i] - 3
            int j = binarySearch(vals, vals.get(i) - 3);
            if (j >= 0) take += dp[j];

            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }
     private int binarySearch(List<Long> vals, long target) {
        int l = 0, r = vals.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (vals.get(mid) <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
