import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            int ans = m; 

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            res[i] = m - ans;
        }

        return res;
    }
}
