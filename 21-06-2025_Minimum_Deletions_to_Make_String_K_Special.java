public class Solution {
    public static int minDeletionsToMakeKSpecial(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs);

        int n = freqs.size();
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + freqs.get(i);
        }

        int minDeletions = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int minFreq = freqs.get(i);
            int maxAllowed = minFreq + k;

            int left = i, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (freqs.get(mid) <= maxAllowed)
                    left = mid + 1;
                else
                    right = mid;
            }

            int deletionsLeft = prefixSum[i];
            int deletionsRight = prefixSum[n] - prefixSum[left] - (maxAllowed * (n - left));
            minDeletions = Math.min(minDeletions, deletionsLeft + deletionsRight);
        }

        return minDeletions;
    }
}

