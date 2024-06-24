import java.util.Arrays;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int[] flipped = new int[nums.length];
        int times = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                times -= flipped[i - k];
            }
            if (((nums[i] == 1 && times % 2 == 1) || (nums[i] == 0 && times % 2 == 0))) {
                if (i + k > nums.length) {
                    return -1;
                }
                ans++;
                times++;
                flipped[i] = 1;
            }
        }
        return ans;
    }
}

