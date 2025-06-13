class Solution {
    public int maxAdjacentDistance(List<Integer> nums) {
        if (nums.size() < 2) return 0;
        
        int maxDiff = Math.abs(nums.get(nums.size() - 1) - nums.get(0));
        
        for (int i = 0; i < nums.size() - 1; i++) {
            int currentDiff = Math.abs(nums.get(i) - nums.get(i + 1));
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }
        
        return maxDiff;
    }
}