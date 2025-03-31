class Solution {
    //public long putMarbles(int[] weights, int k) {
        
    //}
    public  long putMarbles(int[] weights, int k) {
        if (k == 1) {
            return 0;  // Only one partition, so no difference.
        }
        
        int n = weights.length;
        long[] pairs = new long[n - 1];
        
        // Create pairwise adjacent sums
        for (int i = 0; i < n - 1; i++) {
            pairs[i] = (long) weights[i] + weights[i + 1];
        }
        
        // Sort the pairs
        Arrays.sort(pairs);
        
        // Calculate min and max scores
        long minScore = 0;
        long maxScore = 0;
        
        for (int i = 0; i < k - 1; i++) {
            minScore += pairs[i];
            maxScore += pairs[n - 2 - i];
        }
        
        return maxScore - minScore;
    }
}
