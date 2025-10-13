import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String a = words[i];
            String b = ans.get(ans.size() - 1);
            
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            Arrays.sort(aChars);
            Arrays.sort(bChars);
            
            if (!Arrays.equals(aChars, bChars)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}