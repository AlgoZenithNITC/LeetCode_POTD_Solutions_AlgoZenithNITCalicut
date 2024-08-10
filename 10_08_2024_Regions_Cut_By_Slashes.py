class Solution:
    def dfs(self, i, j, mat, vis):
        vis[i][j] = 1
        n, m = len(mat), len(mat[0])
        delr = [-1, 0, 1, 0]
        delc = [0, 1, 0, -1]
        for k in range(4):
            nrow, ncol = i + delr[k], j + delc[k]
            if nrow < 0 or nrow >= n or ncol < 0 or ncol >= m or mat[nrow][ncol] != 0 or vis[nrow][ncol]:
                continue
            self.dfs(nrow, ncol, mat, vis)

    def regionsBySlashes(self, grid):
        n = len(grid)
        mat = [[0] * (n * 3) for _ in range(n * 3)]
        for i in range(n):
            for j in range(n):
                if grid[i][j] == '/':
                    mat[i * 3][j * 3 + 2] = 1
                    mat[i * 3 + 1][j * 3 + 1] = 1
                    mat[i * 3 + 2][j * 3] = 1
                elif grid[i][j] == '\\':
                    mat[i * 3][j * 3] = 1
                    mat[i * 3 + 1][j * 3 + 1] = 1
                    mat[i * 3 + 2][j * 3 + 2] = 1

        count = 0
        vis = [[0] * (n * 3) for _ in range(n * 3)]
        for i in range(n * 3):
            for j in range(n * 3):
                if mat[i][j] == 0 and not vis[i][j]:
                    count += 1
                    self.dfs(i, j, mat, vis)
        return count

