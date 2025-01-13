class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        int minLen = 0;
        for (int count : freqMap.values()) {
            minLen += (count % 2 == 0) ? 2 : 1;
        }
        
        return minLen;
    }
}
