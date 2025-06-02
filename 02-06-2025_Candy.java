class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;

        int candy = n;
        int i = 1;

        while (i < n) {
            while (i < n && ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (i < n && ratings[i - 1] < ratings[i]) {
                peak++;
                candy += peak;
                i++;
            }

            int depth = 0;
            while (i < n && ratings[i - 1] > ratings[i]) {
                depth++;
                candy += depth;
                i++;
            }

            candy -= Math.min(peak, depth);
        }

        return candy;
    }
}
