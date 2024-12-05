class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length();
        start += 'x'; target += 'x'; //to mark the end of the string
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            if (start.charAt(i) != target.charAt(j)) return false;
            if (start.charAt(i) == 'L' && j > i) return false;
            if (start.charAt(i) == 'R' && j < i) return false;
            i++; j++;
        }
        return true;
    }
}
