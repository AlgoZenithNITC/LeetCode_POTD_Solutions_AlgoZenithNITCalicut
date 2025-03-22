class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

       List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Set<Integer> component = new HashSet<>();
                DFS(i, adjList, visited, component);

                boolean complete = true;
                int nodeCount = component.size();

                for (int v : component) {
                    if (adjList.get(v).size() != nodeCount - 1) {
                        complete = false;
                        break;
                    }
                }

                if (complete) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void DFS(int s, List<List<Integer>> adjList, boolean[] visited, Set<Integer> component) {
        if (!visited[s]) {
            visited[s] = true;
            component.add(s);
        }

        for (int v : adjList.get(s)) {
            if (!visited[v]) {
                DFS(v, adjList, visited, component);
            }
        }
    }
}
