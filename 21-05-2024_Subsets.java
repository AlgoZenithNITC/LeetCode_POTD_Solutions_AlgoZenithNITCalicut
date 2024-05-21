class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        int n = nums.length;
        for (int m = 0; m < (1 << n) - 1; m++) {
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((m & (1 << i)) != 0) {
                    sub.add(nums[i]);
                }
            }
            ans.add(sub);
        }
        ans.add(new ArrayList<>(Arrays.asList(nums)));
        return ans;
    }
}

