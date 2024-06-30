import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxNumEdgesToRemove(int n, List<List<Integer>> edges) {
        class UnionFind {
            int[] parent;
            int[] size;
            int components;

            UnionFind(int n) {
                components = n;
                parent = new int[n + 1];
                size = new int[n + 1];
                for (int i = 0; i <= n; ++i) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean unite(int x, int y) {
                int rootX = find(x), rootY = find(y);
                if (rootX == rootY) return false;
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                components--;
                return true;
            }

            boolean isConnected() {
                return components == 1;
            }
        }

        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int edgesRequired = 0;

        // Process type 3 edges first
        for (List<Integer> edge : edges) {
            if (edge.get(0) == 3) {
                if (alice.unite(edge.get(1), edge.get(2)) | bob.unite(edge.get(1), edge.get(2))) {
                    edgesRequired++;
                }
            }
        }

        // Process type 1 and type 2 edges
        for (List<Integer> edge : edges) {
            if (edge.get(0) == 1) {
                if (alice.unite(edge.get(1), edge.get(2))) {
                    edgesRequired++;
                }
            } else if (edge.get(0) == 2) {
                if (bob.unite(edge.get(1), edge.get(2))) {
                    edgesRequired++;
                }
            }
        }

        // Check if both are fully connected
        if (alice.isConnected() && bob.isConnected()) {
            return edges.size() - edgesRequired;
        }

        return -1;
    }
}

