import java.util.*;

public class Solution {

    // Helper function to calculate the minimum number of swaps to sort the array
    public int minSwaps(List<Integer> arr) {
        int n = arr.size();

        // Create a list of pairs where each pair is {value, original index}
        List<Map.Entry<Integer, Integer>> v = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            v.add(new AbstractMap.SimpleEntry<>(arr.get(i), i));
        }

        // Sort the list based on values
        Collections.sort(v, (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Iterate over the sorted list to calculate minimum swaps
        for (int i = 0; i < n; ++i) {
            // If already visited or already in the correct place, continue
            if (visited[i] || v.get(i).getValue() == i) {
                continue;
            }

            // Start the cycle of swapping elements
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = v.get(j).getValue(); // Move to the next element in the cycle
                cycleSize++;
            }

            // If there is a cycle of size n, we need (n-1) swaps to sort it
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    // Function to compute the minimum operations on the binary tree
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;

        // Perform level-order traversal
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();

            // Process each level
            for (int i = 0; i < sz; i++) {
                TreeNode currNode = q.poll();
                temp.add(currNode.val);

                // Push the child nodes to the queue for next level
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }

            // For this level, calculate the minimum swaps required
            ans += minSwaps(temp);
        }

        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    }
