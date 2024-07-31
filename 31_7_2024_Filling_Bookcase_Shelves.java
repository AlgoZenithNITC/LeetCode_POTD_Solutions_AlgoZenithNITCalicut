
class Solution {
    int n, n_width;

    public int solve(int i, int[][] books, int width, int height, int[][] memo) {
        int maxHeight = Math.max(height, books[i][1]);

        if (i == n - 1) {
            if (books[i][0] <= width) return maxHeight;
            return height + books[i][1];
        }

        if (memo[i][width] != -1) return memo[i][width];

        int f_shelf = Integer.MAX_VALUE;
        if (books[i][0] <= width) {
            f_shelf = solve(i + 1, books, width - books[i][0], maxHeight, memo);
        }

        int s_shelf = height + solve(i + 1, books, n_width - books[i][0], books[i][1], memo);

        return memo[i][width] = Math.min(f_shelf, s_shelf);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        n_width = shelfWidth;

        int[][] memo = new int[n][shelfWidth + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, books, shelfWidth, 0, memo);
    }
}
