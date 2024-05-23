class Solution {
    private Map<Integer, Integer> countMap = new HashMap<>();
    private int subsetCount = 0;

    private void dfs(int[] nums, int k, int index) {
        if (index == nums.length) {
            subsetCount++;
            return;
        }
        int currentNum = nums[index];
        // Check if the current number can be included in the subset
        if (!countMap.containsKey(currentNum - k) && !countMap.containsKey(currentNum + k)) {
            countMap.put(currentNum, countMap.getOrDefault(currentNum, 0) + 1);
            dfs(nums, k, index + 1);
            countMap.put(currentNum, countMap.get(currentNum) - 1);
            if (countMap.get(currentNum) == 0) {
                countMap.remove(currentNum);
            }
        }
        // Proceed without including the current number
        dfs(nums, k, index + 1);
    }

    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums, k, 0);
        return subsetCount - 1; // Subtract 1 to exclude the empty subset
    }
}
