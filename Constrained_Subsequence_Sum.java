class Solution {
    public int constrainedSubsetSum(int[] nums, int k){
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = nums[i];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{nums[0], 0});
        int ans = dp[0];
        for(int i = 1; i < n; i++){
            while(!pq.isEmpty() && i - pq.peek()[1] > k){
                pq.poll();
            }
            dp[i] = Math.max(dp[i], nums[i] + pq.peek()[0]);
            pq.offer(new int[]{dp[i], i});
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
