public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
    int n = startTime.length;
    int l = 0, r = k - 1;
    int ans = 0, temp = 0;

    for (int i = 0; i < k; i++) {
        temp += endTime[i] - startTime[i];
    }

    int left = 0, right = endTime[k - 1];

    while (r < n) {
        if (l - 1 >= 0) left = endTime[l - 1];
        else left = 0;

        if (r + 1 < n) right = startTime[r + 1];
        else right = eventTime;

        ans = Math.max(ans, right - left - temp);

        temp -= endTime[l] - startTime[l];
        l++;
        r++;
        if (r >= n) break;
        temp += endTime[r] - startTime[r];
    }

    return ans;
}
