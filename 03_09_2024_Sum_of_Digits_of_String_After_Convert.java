class Solution {
    public int getLucky(String s, int k) {
        if (s.equals("")) {
            return 0;
        }

        StringBuilder num = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = c - 'a' + 1;
            num.append(n);
        }
        
        int ans = 0;
        while (k > 0) {
            ans = 0;
            for (char digit : num.toString().toCharArray()) {
                ans += digit - '0';
            }
            num = new StringBuilder(String.valueOf(ans));
            k--;
        }
        return ans;
    }
}

