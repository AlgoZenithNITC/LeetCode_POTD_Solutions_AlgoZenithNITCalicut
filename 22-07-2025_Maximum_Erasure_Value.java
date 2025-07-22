public int maximumUniqueSubarray(int[] arr) {
    int n = arr.length;
    int l = 0, r = 0;
    int cum = 0, ans = 0;
    Map<Integer, Integer> mp = new HashMap<>();

    while (r < n) {
        mp.put(arr[r], mp.getOrDefault(arr[r], 0) + 1);
        cum += arr[r];
        r++;

        // shrink window until all elements are unique
        while (mp.size() < r - l) {
            int leftVal = arr[l];
            mp.put(leftVal, mp.get(leftVal) - 1);
            cum -= leftVal;
            if (mp.get(leftVal) == 0) {
                mp.remove(leftVal);
            }
            l++;
        }

        if (mp.size() == r - l) {
            ans = Math.max(ans, cum);
        }
    }

    return ans;
}
