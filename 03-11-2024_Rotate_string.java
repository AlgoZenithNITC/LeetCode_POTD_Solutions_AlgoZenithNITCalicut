class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        s = s + s;
        int i = 0, j = 0;
        int n = goal.length();

        while (i < 2 * n && j < n) {
            if (s.charAt(i) == goal.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }

            if (j == n) {
                return true;
            }
        }

        return false;
    }
}
