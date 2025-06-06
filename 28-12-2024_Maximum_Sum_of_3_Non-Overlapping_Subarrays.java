class Solution 
{

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) 
    {
        int n = nums.length;
        int maxSum = 0;

        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) 
        {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[] leftMaxIndex = new int[n];
        int[] rightMaxIndex = new int[n];
        int[] result = new int[3];

        for (int i = k, currentMaxSum = prefixSum[k] - prefixSum[0];i < n;i++) 
        {
            if (prefixSum[i + 1] - prefixSum[i + 1 - k] > currentMaxSum) 
            {
                leftMaxIndex[i] = i + 1 - k;
                currentMaxSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            } 
            else 
            {
                leftMaxIndex[i] = leftMaxIndex[i - 1];
            }
        }
        rightMaxIndex[n - k] = n - k;
        for ( int i = n - k - 1, currentMaxSum = prefixSum[n] - prefixSum[n - k];i >= 0; i--) 
        {
            if (prefixSum[i + k] - prefixSum[i] >= currentMaxSum) 
            {
                rightMaxIndex[i] = i;
                currentMaxSum = prefixSum[i + k] - prefixSum[i];
            } 
            else 
            {
                rightMaxIndex[i] = rightMaxIndex[i + 1];
            }
        }
        for (int i = k; i <= n - 2 * k; i++) 
        {
            int leftIndex = leftMaxIndex[i - 1];
            int rightIndex = rightMaxIndex[i + k];
            int totalSum =
                (prefixSum[i + k] - prefixSum[i]) +
                (prefixSum[leftIndex + k] - prefixSum[leftIndex]) +
                (prefixSum[rightIndex + k] - prefixSum[rightIndex]);

            if (totalSum > maxSum) 
            {
                maxSum = totalSum;
                result[0] = leftIndex;
                result[1] = i;
                result[2] = rightIndex;
            }
        }

        return result;
    }
}