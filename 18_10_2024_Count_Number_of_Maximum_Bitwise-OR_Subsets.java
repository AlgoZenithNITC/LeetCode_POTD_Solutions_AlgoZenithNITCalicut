import java.util.List;

class Solution {
    public int solve(int i, int ors, int maxi, List<Integer> nums) {
        if (i >= nums.size()) {
            return (ors == maxi) ? 1 : 0;
        }

        int cnt = 0;
        cnt += solve(i + 1, ors | nums.get(i), maxi, nums);
        cnt += solve(i + 1, ors, maxi, nums);

        return cnt;
    }

    public int countMaxOrSubsets(List<Integer> nums) {
        int maxi = 0;

        for (int it : nums) {
            maxi |= it;
        }

        return solve(0, 0, maxi, nums);
    }
}

