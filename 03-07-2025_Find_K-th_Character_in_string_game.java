class Solution {
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("ab");
        while (s.length() < k) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'z') {
                    temp.append('a');
                } else {
                    temp.append((char)(ch + 1));
                }
            }
            s.append(temp);
        }
        return s.charAt(k - 1);
    }
}
