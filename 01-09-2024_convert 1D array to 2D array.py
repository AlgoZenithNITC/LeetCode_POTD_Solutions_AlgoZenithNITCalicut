class Solution:
    def create2DArray(self, arr, rows, cols):
        if rows * cols != len(arr):
            return []
        matrix = [[0] * cols for _ in range(rows)]
        idx = 0
        for i in range(rows):
            for j in range(cols):
                matrix[i][j] = arr[idx]
                idx += 1
        return matrix
