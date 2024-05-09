class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            happiness[happiness.length - 1 - i] -= i;
            if (happiness[happiness.length - 1 - i] > 0)
                maxSum += happiness[happiness.length - 1 - i];
            else
                break;
        }
        return maxSum;
    }
}
