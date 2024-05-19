class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        long cnt = 0;
        long temp = Long.MAX_VALUE;

        for (int it : nums) {
            int a = it ^ k;
            long b = (long) a - it;
            if (a > it) {
                sum += a;
                temp = Math.min(temp, b);
                cnt++;
            } else {
                sum += it;
                temp = Math.min(temp, -b);
            }
        }

        if (cnt % 2 == 0) return sum;

        return sum - temp;
    }
}
