class Solution:
    def __init__(self):
        self.dr = [-1, 1, 1, -1]
        self.dc = [1, 1, -1, -1]

    def inBounds(self, r, c, n, m):
        return 0 <= r < n and 0 <= c < m

    def dfs(self, grid, r, c, dir, canChange, length, searchFor):
        n, m = len(grid), len(grid[0])
        maxi = length

        if dir != -1:
            nr, nc = r + self.dr[dir], c + self.dc[dir]
            if self.inBounds(nr, nc, n, m) and grid[nr][nc] == searchFor:
                nextVal = 0 if searchFor == 2 else 2
                maxi = max(maxi, self.dfs(grid, nr, nc, dir, canChange, length + 1, nextVal))

        if dir != -1 and canChange:
            ndir = (dir + 1) % 4
            nr, nc = r + self.dr[ndir], c + self.dc[ndir]
            if self.inBounds(nr, nc, n, m) and grid[nr][nc] == searchFor:
                nextVal = 0 if searchFor == 2 else 2
                maxi = max(maxi, self.dfs(grid, nr, nc, ndir, False, length + 1, nextVal))

        if dir == -1:
            for i in range(4):
                nr, nc = r + self.dr[i], c + self.dc[i]
                if self.inBounds(nr, nc, n, m) and grid[nr][nc] == searchFor:
                    nextVal = 0 if searchFor == 2 else 2
                    maxi = max(maxi, self.dfs(grid, nr, nc, i, canChange, length + 1, nextVal))

        return maxi

    def lenOfVDiagonal(self, grid):
        n, m = len(grid), len(grid[0])
        maxi = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    maxi = max(maxi, self.dfs(grid, i, j, -1, True, 1, 2))

        return maxi
