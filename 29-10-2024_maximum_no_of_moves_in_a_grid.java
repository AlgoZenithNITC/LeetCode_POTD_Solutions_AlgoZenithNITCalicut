class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int col = n - 2; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                if (row > 0 && grid[row - 1][col + 1] > grid[row][col])
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row - 1][col + 1]);
                if (grid[row][col + 1] > grid[row][col])
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row][col + 1]);
                if (row < m - 1 && grid[row + 1][col + 1] > grid[row][col])
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row + 1][col + 1]);
            }
        }
        int maxMoves = 0;
        for (int row = 0; row < m; row++) {
            maxMoves = Math.max(maxMoves, dp[row][0]);
        }

        return maxMoves;
    }
}
