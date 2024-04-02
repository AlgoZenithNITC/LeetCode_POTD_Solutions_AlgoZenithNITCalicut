public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] S = new int[200];
        int[] T = new int[200];
        Arrays.fill(S, 0);
        Arrays.fill(T, 0);

        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (S[s.charAt(i)] != T[t.charAt(i)]) {
                return false;
            }
            S[s.charAt(i)] = i + 1;
            T[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
