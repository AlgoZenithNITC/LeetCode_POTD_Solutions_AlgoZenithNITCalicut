import java.util.HashMap;

class Solution {
    public int CountAtMost(int[] nums, int k) {
        int count = 0;
        int j = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while (j <= i && mp.size() > k) {
                if (mp.get(nums[j]) - 1 == 0) {
                    mp.remove(nums[j]);
                } else {
                    mp.put(nums[j], mp.get(nums[j]) - 1);
                }
                j++;
            }
            count += (i - j + 1);
        }
        return count;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        int k1 = CountAtMost(nums, k);
        int k2 = CountAtMost(nums, k - 1);
        return k1 - k2;
    }
}

