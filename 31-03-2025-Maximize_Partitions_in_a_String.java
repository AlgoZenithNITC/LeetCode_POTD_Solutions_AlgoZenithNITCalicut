class Solution {
    public int maxPartitions(String s) {
        int n = s.length();
        int[] lastIndex = new int[26];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int farthest = 0, left = 0;
        for (int i = 0; i < n; ++i) {
            farthest = Math.max(farthest, lastIndex[s.charAt(i) - 'a']);
            if (i == farthest) {
                ans.add(farthest - left + 1);
                left = i + 1;
            }
        }
        return ans.size();
    }
}
