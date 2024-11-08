public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int numsSize = nums.length;
        int[] answer = new int[numsSize];
        int[] xorPrefix = new int[numsSize];
        
        xorPrefix[0] = nums[0];
        for (int i = 1; i < numsSize; i++) {
            xorPrefix[i] = xorPrefix[i - 1] ^ nums[i];
        }
        
        int maxNum = (1 << maximumBit) - 1; // Max number with `maximumBit` bits all set to 1
        
        for (int i = 0; i < numsSize; i++) {
            answer[i] = xorPrefix[numsSize - i - 1] ^ maxNum;
        }
        
        return answer;
    }
}
