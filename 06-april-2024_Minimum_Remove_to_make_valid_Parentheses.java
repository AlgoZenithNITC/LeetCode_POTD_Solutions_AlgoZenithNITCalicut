class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> st = new Stack<>();

        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(new Pair('(', i));
            }
            if (ch == ')') {
                if (st.isEmpty()) {
                    sb.setCharAt(i, '#');
                } else {
                    st.pop();
                }
            }
        }

        while (!st.isEmpty()) {
            sb.setCharAt(st.peek().index, '#');
            st.pop();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '#') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }

    private class Pair {
        char bracket;
        int index;

        Pair(char bracket, int index) {
            this.bracket = bracket;
            this.index = index;
        }
    }
}
