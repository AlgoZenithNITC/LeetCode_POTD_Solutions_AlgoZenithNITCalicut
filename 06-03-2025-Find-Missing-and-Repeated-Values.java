class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        int size = n * n + 1;
        int[] map = new int[size];
        int[] res = new int[2];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                map[value]++;
            }
        }

        int num1 = -1, num2 = -1;

 
        for (int i = 1; i < size; i++) {
            if (map[i] == 2) {
                num1 = i;
            } else if (map[i] == 0) {
                num2 = i;
            }
        }

        res[0] = num1;
        res[1] = num2;

        return res;
    }
}
