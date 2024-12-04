class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            } else if (str1.charAt(i) == 'z') {
                if ('a' == str2.charAt(j)) {
                    j++;
                }
            } else {
                if ((char)(str1.charAt(i) + 1) == str2.charAt(j)) {
                    j++;
                }
            }
            i++;
        }
        return j == str2.length();
    }
}
