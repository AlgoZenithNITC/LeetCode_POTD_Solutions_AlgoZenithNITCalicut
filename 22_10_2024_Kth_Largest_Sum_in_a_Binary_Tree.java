class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0; // or some indication of invalid input
        }

        List<Long> sums = levelOrder(root);

        Collections.sort(sums, Collections.reverseOrder()); // Sort in descending order

        if (k > sums.size()) {
            return 0; // or some indication of invalid input
        }

        return sums.get(k - 1); // k-th largest means (k-1) in 0-based index
    }

    List<Long> levelOrder(TreeNode root) {
        List<Long> sums = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>(); // Using List as a queue

        queue.add(root);

        while (!queue.isEmpty()) {
            long levelSum = 0;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove(0);
                levelSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            sums.add(levelSum);
        }

        return sums;
    }
}
