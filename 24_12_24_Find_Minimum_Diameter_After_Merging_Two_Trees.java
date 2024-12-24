import java.util.ArrayList;
import java.util.List;

class Solution {
    public int dfs(List<List<Integer>> adj, int node, int parent, int[] diameter) {
        int maxD1 = 0, maxD2 = 0;

        for (int nei : adj.get(node)) {
            if (nei != parent) {
                int depth = dfs(adj, nei, node, diameter);
                if (depth > maxD1) {
                    maxD2 = maxD1;
                    maxD1 = depth;
                } else if (depth > maxD2) {
                    maxD2 = depth;
                }
            }
        }
        diameter[0] = Math.max(diameter[0], maxD1 + maxD2);
        return maxD1 + 1; 
    }

    public int treeDiameter(List<List<Integer>> edges) {
        if (edges.isEmpty()) return 0;
        int n = edges.size() + 1;
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        int[] dia = new int[1];
        dfs(adj, 0, -1, dia);
        return dia[0];
    }

    public int minimumDiameterAfterMerge(List<List<Integer>> edges1, List<List<Integer>> edges2) {
        int dia1 = treeDiameter(edges1);
        int dia2 = treeDiameter(edges2);

        int half1 = (dia1 + 1) / 2;
        int half2 = (dia2 + 1) / 2;

        return Math.max(Math.max(dia1, dia2), half1 + half2 + 1);
    }
}

