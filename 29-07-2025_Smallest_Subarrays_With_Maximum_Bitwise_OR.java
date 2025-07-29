class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] last = new int[32];
        Arrays.fill(last, -1);

        int[] res = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            for (int b = 0; b < 32; ++b) {
                if ((nums[i] & (1 << b)) != 0) {
                    last[b] = i;
                }
            }
            int farthest = i;
            for (int b = 0; b < 32; ++b) {
                if (last[b] != -1) {
                    farthest = Math.max(farthest, last[b]);
                }
            }
            res[i] = Math.max(1, farthest - i + 1);
        }

        return res;
    }
}
