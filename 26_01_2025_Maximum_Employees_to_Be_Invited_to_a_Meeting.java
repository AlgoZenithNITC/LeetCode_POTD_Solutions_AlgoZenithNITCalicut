

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        int[] longestChain = new int[n];
        boolean[] visited = new boolean[n];

        for (int f : favorite) {
            inDegree[f]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int front = queue.poll();
            visited[front] = true;
            int next = favorite[front];
            longestChain[next] = longestChain[front] + 1;

            if (--inDegree[next] == 0) {
                queue.add(next);
            }
        }

        int maxCycle = 0, total = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int c = i, len = 0;
                while (!visited[c]) {
                    visited[c] = true;
                    c = favorite[c];
                    len++;
                }

                if (len == 2) {
                    total += (2 + longestChain[i] + longestChain[favorite[i]]);
                } else {
                    maxCycle = Math.max(maxCycle, len);
                }
            }
        }

        return Math.max(total, maxCycle);
    }
}
