class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        // Store index of each element in arr for quick lookup
        for (int i = 0; i < n; i++) {
            index.put(arr[i], i);
        }

        // Iterate over all pairs (j, k) to find valid (i, j, k) triplets
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int prev = arr[k] - arr[j];
                int i = index.getOrDefault(prev, -1);

                if (i >= 0 && i < j) {
                    int key = j * n + k;  // Unique key for dp
                    int prevKey = i * n + j;
                    dp.put(key, dp.getOrDefault(prevKey, 2) + 1);
                    maxLen = Math.max(maxLen, dp.get(key));
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
