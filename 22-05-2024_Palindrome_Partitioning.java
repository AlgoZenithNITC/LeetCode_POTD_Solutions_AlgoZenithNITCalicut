class Solution {
    private boolean isPalindrome(int a, int b, String s) {
        int i = a, j = b;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private void solve(int a, String s, List<List<String>> ans, List<String> temp) {
        if (a == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = a; i < s.length(); i++) {
            temp.add(s.substring(a, i + 1));
            if (isPalindrome(a, i, s))
                solve(i + 1, s, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(0, s, ans, temp);
        return ans;
    }
}
