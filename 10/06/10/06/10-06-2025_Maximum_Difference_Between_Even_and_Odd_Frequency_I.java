import java.util.HashMap;

class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int maxf = 0;
        int minf = s.length();
        
        for (int count : freq.values()) {
            if ((count & 1) == 1) {
                maxf = Math.max(maxf, count);
            } else {
                minf = Math.min(minf, count);
            }
        }
        
        if (minf == s.length()) return maxf;
        return maxf - minf;
    }
            }
