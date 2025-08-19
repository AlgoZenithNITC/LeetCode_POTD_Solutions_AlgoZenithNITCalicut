class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long zeroLength = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroLength++;
                count += zeroLength;
            } else {
                zeroLength = 0;
            }
        }

        return count;
    }
}
