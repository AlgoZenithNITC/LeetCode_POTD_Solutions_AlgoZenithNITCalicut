class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int l = 0, j = 0, l_cost = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            l++;
            l_cost += temp[i];

            if (l_cost > maxCost) {
                ans = Math.max(ans, l - 1);
                while (l_cost > maxCost && j <= i) {
                    l--;
                    l_cost -= temp[j];
                    j++;
                }
            }
        }

        ans = Math.max(ans, l);

        return ans;
    }
}
