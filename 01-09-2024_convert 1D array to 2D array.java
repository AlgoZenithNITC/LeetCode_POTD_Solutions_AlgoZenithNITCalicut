class Solution {
    public int[][] create2DArray(int[] arr, int rows, int cols) {
        if (rows * cols != arr.length) {
            return new int[0][0];
        }
        int[][] matrix = new int[rows][cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[idx];
                idx++;
            }
        }
        return matrix;
    }
}
