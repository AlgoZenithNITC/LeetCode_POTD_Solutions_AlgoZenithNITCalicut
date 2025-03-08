class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, now = 0, nr = Integer.MAX_VALUE;
        
        for (int right = 0; right < blocks.length(); right++) {
            if (blocks.charAt(right) == 'W') {
                now++;
            }
            if (right - left + 1 == k) {
                nr = Math.min(nr, now);
                if (blocks.charAt(left) == 'W') {
                    now--;
                }
                left++;
            }
        }
        return nr;
    }
}
