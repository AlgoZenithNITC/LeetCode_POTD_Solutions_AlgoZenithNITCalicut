class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 1}); 

        int[] uniqueVisit = new int[n + 1];  
        int[] dis = new int[n + 1];  
        Arrays.fill(dis, -1);
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int t = current[0], node = current[1];
            
            if (dis[node] == t || uniqueVisit[node] >= 2) {
                continue;
            }
            
            uniqueVisit[node]++;
            dis[node] = t;
            
            if (node == n && uniqueVisit[node] == 2) {
                return dis[node];
            }
            
            if ((t / change) % 2 != 0) {
                t = (t / change + 1) * change;
            }
            
            for (int nei : g.getOrDefault(node, new ArrayList<>())) {
                q.offer(new int[]{t + time, nei});
            }
        }
        
        return -1;
    }
}

