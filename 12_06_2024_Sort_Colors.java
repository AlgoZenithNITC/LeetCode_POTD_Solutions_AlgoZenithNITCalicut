class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        
        int idx = 0;
        for (int key = 0; key < 3; key++) {
            int count = mp.getOrDefault(key, 0);
            for (int i = 0; i < count; i++) {
                nums[idx++] = key;
            }
        }
    }
}

