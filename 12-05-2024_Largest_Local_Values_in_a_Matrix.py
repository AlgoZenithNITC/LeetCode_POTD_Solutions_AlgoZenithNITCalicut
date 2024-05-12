class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        maxLocal = [[0] * (n - 2) for _ in range(n - 2)]
        
        for i in range(n - 2):
            for j in range(n - 2):
                largestValue = 0
                for k in range(i, i + 3):
                    for z in range(j, j + 3):
                        largestValue = max(largestValue, grid[k][z])
                maxLocal[i][j] = largestValue
        
        return maxLocal
