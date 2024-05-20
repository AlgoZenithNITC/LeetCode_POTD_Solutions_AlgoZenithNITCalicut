class Solution {
public:
    void calculateSubsetXORSum(const std::vector<int>& nums, int n, int& sum, int i, int currentXOR) {
        if (i == n) {
            sum += currentXOR;
            return;
        }
        // Exclude the current element from the subset
        calculateSubsetXORSum(nums, n, sum, i + 1, currentXOR);   
        // Include the current element in the subset
        calculateSubsetXORSum(nums, n, sum, i + 1, currentXOR ^ nums[i]);
    }

    int subsetXORSum(const std::vector<int>& nums) {
        int sum = 0;
        calculateSubsetXORSum(nums, nums.size(), sum, 0, 0);
        return sum;
    }
};
