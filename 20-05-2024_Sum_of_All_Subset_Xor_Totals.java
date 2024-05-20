class Solution {
    private void calculateSubsetXORSum(int[] nums, int n, int[] sum, int i, int currentXOR) {
        if (i == n) {
            sum[0] += currentXOR;
            return;
        }
        // Exclude the current element from the subset
        calculateSubsetXORSum(nums, n, sum, i + 1, currentXOR);
        // Include the current element in the subset
        calculateSubsetXORSum(nums, n, sum, i + 1, currentXOR ^ nums[i]);
    }

    public int subsetXORSum(int[] nums) {
        int[] sum = new int[1];
        calculateSubsetXORSum(nums, nums.length, sum, 0, 0);
        return sum[0];
    }
}
