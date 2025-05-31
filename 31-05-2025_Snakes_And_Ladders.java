class Solution {
    private int[] BoustrophedonPosition(int k, int n) {
        int row = n - 1 - (k - 1) / n;
        int col = (k - 1) % n;
        if (((k - 1) / n) % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cur = curr[0];
            int rolls = curr[1];
            
            if (cur == n * n) {
                return rolls;
            }
            
            for (int i = 6; i > 0; i--) {
                int next_square = cur + i;
                if (next_square > n * n) continue;
                
                int[] pos = BoustrophedonPosition(next_square, n);
                int x = pos[0], y = pos[1];
                
                if (board[x][y] == -1) {
                    if (next_square == n * n) return rolls + 1;
                    if (visited[next_square - 1]) continue;
                    visited[next_square - 1] = true;
                    queue.offer(new int[]{next_square, rolls + 1});
                } else {
                    int dest = board[x][y];
                    if (dest == n * n) return rolls + 1;
                    if (visited[dest - 1]) continue;
                    visited[dest - 1] = true;
                    queue.offer(new int[]{dest, rolls + 1});
                }
            }
        }
        return -1;
    }
}
