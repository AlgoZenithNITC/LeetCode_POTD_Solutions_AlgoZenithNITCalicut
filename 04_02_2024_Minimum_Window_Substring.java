import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")) return "";
        Map<Character, Integer> mpt = new HashMap<>();
        for (char x : t.toCharArray()) mpt.put(x, mpt.getOrDefault(x, 0) + 1);
        int len = s.length();
        int[] pr = {-1, -1};
        Map<Character, Integer> mps = new HashMap<>();
        int have = 0, need = mpt.size(), j = 0;
        for (int i = 0; i < s.length(); i++) {
            mps.put(s.charAt(i), mps.getOrDefault(s.charAt(i), 0) + 1);
            if (mpt.containsKey(s.charAt(i)) && mps.get(s.charAt(i)).equals(mpt.get(s.charAt(i)))) {
                have++;
            }
            while (have == need) {
                if (i - j + 1 <= len) {
                    pr[0] = j;
                    pr[1] = i;
                    len = i - j + 1;
                }
                mps.put(s.charAt(j), mps.get(s.charAt(j)) - 1);
                if (mpt.containsKey(s.charAt(j)) && mps.get(s.charAt(j)) < mpt.get(s.charAt(j))) {
                    have--;
                }
                j++;
            }
        }
        if (pr[1] == -1 || pr[0] == -1) return "";
        return s.substring(pr[0], pr[1] + 1);
    }
}
