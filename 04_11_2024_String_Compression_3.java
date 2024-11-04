class Solution {
    public String compressedString(String word) {
        int n = word.length();
        StringBuilder ans = new StringBuilder();
        int i = 1;
        int st = 0;

        while (i < n) {
            while (i < n && word.charAt(i - 1) == word.charAt(i) && (i - st) < 10) {
                i++;
            }
            if (i - st == 10) {
                i--;
            }
            ans.append(i - st);
            ans.append(word.charAt(st));
            st = i;
            i++;
        }
        
        if (st == n - 1) {
            ans.append(i - st);
            ans.append(word.charAt(st));
        }

        return ans.toString();
    }
}