import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int subArray_length = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArray_length = i + 1;
            } else if (mp.containsKey(sum)) {
                subArray_length = Math.max(subArray_length, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArray_length;
    }
}


