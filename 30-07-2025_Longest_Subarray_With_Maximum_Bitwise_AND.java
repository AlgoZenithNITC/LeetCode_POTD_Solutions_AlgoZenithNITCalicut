class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = 0;
        for (int num : nums) {
            if (num > maxi) {
                maxi = num;
            }
        }
        
        int maxlen = 0, len = 0;
        for (int num : nums) {
            if (num == maxi) {
                len++;
                maxlen = Math.max(maxlen, len);
            } else {
                len = 0;
            }
        }
        return maxlen;
    }
}
