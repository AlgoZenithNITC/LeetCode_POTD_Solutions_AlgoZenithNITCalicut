class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])

        # Initialize the 3D DP array with -1
        DP = [[[-1] * cols for _ in range(cols)] for _ in range(rows)]

        # Base case: bottom row
        for j1 in range(cols):
            for j2 in range(cols):
                DP[rows - 1][j1][j2] = grid[rows - 1][j1]
                if j1 != j2:
                    DP[rows - 1][j1][j2] += grid[rows - 1][j2]

        # Iterate from the second-to-last row up to the top
        for i in range(rows - 2, -1, -1):
            for j1 in range(cols):
                for j2 in range(cols):
                    cherries = grid[i][j1]
                    if j1 != j2:
                        cherries += grid[i][j2]

                    # Iterate over the possible next positions for both robots
                    for nj1 in range(j1 - 1, j1 + 2):
                        for nj2 in range(j2 - 1, j2 + 2):
                            # Check if the next positions are within bounds
                            if 0 <= nj1 < cols and 0 <= nj2 < cols:
                                DP[i][j1][j2] = max(DP[i][j1][j2], cherries + DP[i + 1][nj1][nj2])

        # The answer is stored in DP[0][0][cols - 1]
        return DP[0][0][cols - 1]
