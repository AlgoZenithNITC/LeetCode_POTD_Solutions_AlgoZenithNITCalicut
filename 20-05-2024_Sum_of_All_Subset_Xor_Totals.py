class Solution:
    def calculateSubsetXORSum(self, nums: List[int], n: int, i: int, currentXOR: int, sum: List[int]) -> None:
        if i == n:
            sum[0] += currentXOR
            return
        # Exclude the current element from the subset
        self.calculateSubsetXORSum(nums, n, i + 1, currentXOR, sum)
        # Include the current element in the subset
        self.calculateSubsetXORSum(nums, n, i + 1, currentXOR ^ nums[i], sum)

    def subsetXORSum(self, nums: List[int]) -> int:
        sum = [0]
        self.calculateSubsetXORSum(nums, len(nums), 0, 0, sum)
        return sum[0]
