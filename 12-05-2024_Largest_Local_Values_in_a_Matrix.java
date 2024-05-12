class Solution {
    public int[][] largestLocal(int[][] grid) {
         int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int largestValue = 0;
                for (int k = i; k <= i + 2; k++) {
                    for (int z = j; z <= j + 2; z++) {
                        largestValue = Math.max(largestValue, grid[k][z]);
                    }
                }
                maxLocal[i][j] = largestValue;
            }
        }
        
        return maxLocal;
    }
}
