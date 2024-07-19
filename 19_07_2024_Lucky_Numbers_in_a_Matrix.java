import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        for (int r_idx = 0; r_idx < rows; r_idx++) {
            int minEle = matrix[r_idx][0];
            int col_idx = 0;

            // Find the minimum element in the row and its column index
            for (int c = 1; c < cols; c++) {
                if (matrix[r_idx][c] < minEle) {
                    minEle = matrix[r_idx][c];
                    col_idx = c;
                }
            }

            // Check if this minimum element is the maximum in its column
            int r;
            for (r = 0; r < rows; r++) {
                if (matrix[r_idx][col_idx] < matrix[r][col_idx]) {
                    break;
                }
            }

            // If the loop completes, it means minEle is a lucky number
            if (r == rows) {
                ans.add(minEle);
            }
        }

        return ans;
    }
}
