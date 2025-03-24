public int countDays(int days, int[][] meetings) {
    Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
    int r = 0;
    int ans = days;
    
    for (int[] pair : meetings) {
        if (pair[1] <= r) {
            continue;
        } else {
            ans -= (pair[1] - Math.max(pair[0], r));
            if (r < pair[0]) {
                ans--;
            }
            r = pair[1];
        }
    }
    
    return ans;
}
