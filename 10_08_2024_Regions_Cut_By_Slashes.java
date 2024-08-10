class Solution {
    public void dfs(int i, int j, int[][] mat, boolean[][] vis) {
        vis[i][j] = true;
        int n = mat.length, m = mat[0].length;
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int nrow = i + delr[k], ncol = j + delc[k];
            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m || mat[nrow][ncol] != 0 || vis[nrow][ncol]) continue;
            dfs(nrow, ncol, mat, vis);
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] mat = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    mat[i * 3][j * 3 + 2] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    mat[i * 3][j * 3] = 1;
                    mat[i * 3 + 1][j * 3 + 1] = 1;
                    mat[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int count = 0;
        boolean[][] vis = new boolean[n * 3][n * 3];
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (mat[i][j] == 0 && !vis[i][j]) {
                    count++;
                    dfs(i, j, mat, vis);
                }
            }
        }
        return count;
    }
}

