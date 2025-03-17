class Solution {
    public boolean divideArray(int[] nums) {
        int[] hash = new int[501];

        for (int num : nums) {
            hash[num]++;
        }

        for (int i = 0; i < 501; i++) {
            if (hash[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
