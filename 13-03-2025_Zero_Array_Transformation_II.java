class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int left = 0, right = queries.length, answer = -1;

        // Binary search for the minimum `k`
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZero(nums, queries, mid)) {
                answer = mid;
                right = mid - 1; // Try to minimize `k`
            } else {
                left = mid + 1; // Increase `k`
            }
        }

        return answer;
    }

    private boolean canMakeZero(int[] nums, int[][] queries, int mid) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        // Apply the first `mid` queries using the difference array
        for (int i = 0; i < mid; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] -= val;
            diff[r + 1] += val;
        }

        // Apply the difference array to determine the actual decrements
        int[] applied = new int[n];
        int currDecrement = 0;
        for (int i = 0; i < n; i++) {
            currDecrement += diff[i];
            applied[i] = currDecrement;
        }

        // Check if we can reduce all nums[i] to zero
        for (int i = 0; i < n; i++) {
            if (nums[i] + applied[i] > 0) return false;
        }
        return true;
    }
}
