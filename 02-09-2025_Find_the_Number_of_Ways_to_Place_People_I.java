class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int count = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int t = points[i][1];
            int b = -1;
            for (int j = i + 1; j < n; j++) {
                if (b < points[j][1] && points[j][1] <= t) {
                    count++;
                    b = points[j][1];
                    if (t == b) break;
                }
            }
        }
        return count;
    }
}
