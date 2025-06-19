class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        int j = 0;
        int res = 0;

        while (j < nums.length) {
            if ((nums[j] - nums[i]) <= k) {
                j++;
            } else {
                res++;
                i = j;
            }
        }

        return res + 1; // count the final valid group
    }
    
}
