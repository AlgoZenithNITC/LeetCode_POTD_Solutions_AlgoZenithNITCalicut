class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : rowConditions) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }

        List<Integer> rowSorting = topoSort(graph, k);
        graph.clear();
        for (int[] edge : colConditions) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }
        List<Integer> colSorting = topoSort(graph, k);

        if (rowSorting.isEmpty() || colSorting.isEmpty()) {
            return new int[0][0];
        }

        Map<Integer, int[]> valuePosition = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            valuePosition.put(rowSorting.get(i), new int[]{i, -1});
            valuePosition.get(rowSorting.get(i))[1] = i;
        }

        int[][] res = new int[k][k];
        for (int value = 1; value <= k; ++value) {
            int row = valuePosition.get(value)[0];
            int column = valuePosition.get(value)[1];
            res[row][column] = value;
        }

        return res;
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> curPath, List<Integer> res) {
        if (curPath.contains(src)) return false;  
        if (visited.contains(src)) return true;  
        
        visited.add(src);
        curPath.add(src);

        for (int neighbor : graph.getOrDefault(src, new ArrayList<>())) {
            if (!dfs(neighbor, graph, visited, curPath, res))
                return false;
        }

        curPath.remove(src);
        res.add(src);
        return true;
    }

    private List<Integer> topoSort(Map<Integer, List<Integer>> graph, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> curPath = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int src = 1; src <= k; ++src) {
            if (!dfs(src, graph, visited, curPath, res))
                return Collections.emptyList();
        }

        Collections.reverse(res);
        return res;
    }
}

