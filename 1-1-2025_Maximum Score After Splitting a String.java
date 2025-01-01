class Solution {
    public int count1(String s, int j) {
        int c = 0;
        for (int i = 0; i <= j; i++) {
            if (s.charAt(i) == '0') {
                c++;
            }
        }
        return c;
    }

    public int count2(String s, int j) {
        int c = 0;
        for (int i = j; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                c++;
            }
        }
        return c;
    }

    public int maxScore(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int score = count1(s, i) + count2(s, i + 1);
            max = Math.max(max, score);
        }
        return max;
    }
}