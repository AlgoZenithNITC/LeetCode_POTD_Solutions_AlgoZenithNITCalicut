class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        
        int[] diffArray = new int[n];
        
        for (int[] query : shifts) {
            int left = query[0];
            int right = query[1];
            int dir = query[2] == 0 ? -1 : 1;
            
            diffArray[left] += dir;
            
            if (right + 1 < n) {
                diffArray[right + 1] -= dir;
            }
        }
        
        int prefixSum = 0;
        StringBuilder result = new StringBuilder(s);
        
        for (int i = 0; i < n; i++) {
            int pos = result.charAt(i) - 'a';
            
            prefixSum += diffArray[i];
            int newPos = (pos + prefixSum) % 26;
            
            if (newPos < 0) {
                newPos += 26;
            }
            
            result.setCharAt(i, (char) ('a' + newPos));
        }
        
        return result.toString();
        
    }
}
