
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            temp[i] = temp[i - 1] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (a > 0) {
                ans[i] = temp[b] ^ temp[a - 1];
            } else {
                ans[i] = temp[b];
            }
        }

        return ans;
    }
}
