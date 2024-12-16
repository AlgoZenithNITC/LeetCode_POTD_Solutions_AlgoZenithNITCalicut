public int[] getFinalState(int[] nums, int k, int multiplier) {
    if (multiplier == 1) {
        return nums;
    }

    // Priority queue to store (value, index) with a min-heap
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if(a[0] != b[0])
            return (a[0]-b[0]);
        else
            return (a[1]-b[1]);
    });
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        pq.add(new int[]{nums[i], i});
    }

    while (k-- > 0) {
        int[] t = pq.poll();
        t[0] *= multiplier;
        pq.add(t);
    }

    // Reconstruct the final state
    int[] ans = new int[n];
    while (!pq.isEmpty()) {
        int[] t = pq.poll();
        ans[t[1]] = t[0];
    }

    return ans;
}
