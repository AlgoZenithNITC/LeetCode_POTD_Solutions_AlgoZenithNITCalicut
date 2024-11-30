import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        // Build adjacency list and track in/out degrees
        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            adj.computeIfAbsent(u, k -> new ArrayDeque<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        // Find the starting node
        int startNode = pairs[0][0];
        for (int node : adj.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        // Hierholzer's Algorithm to find Eulerian path
        List<Integer> eulerPath = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int curr = stack.peek();
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                int next = adj.get(curr).poll();
                stack.push(next);
            } else {
                eulerPath.add(stack.pop());
            }
        }

        // Reverse the path
        Collections.reverse(eulerPath);

        // Build result as an int[][] array
        int[][] result = new int[eulerPath.size() - 1][2];
        for (int i = 0; i < eulerPath.size() - 1; i++) {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i + 1);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pairs = {{1, 2}, {2, 3}, {3, 1}};
        int[][] result = sol.validArrangement(pairs);

        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
          }
