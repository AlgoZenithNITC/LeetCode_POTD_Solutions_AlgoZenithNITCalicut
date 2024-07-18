/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int ans = 0;

    public List<Integer> dfs(TreeNode root, int d) {
        if (root == null) return new ArrayList<>();

        if (root.left == null && root.right == null) {
            List<Integer> leafList = new ArrayList<>();
            leafList.add(1);
            return leafList;
        }

        List<Integer> left = dfs(root.left, d);
        List<Integer> right = dfs(root.right, d);

        for (int a : left) {
            for (int b : right) {
                if (a + b <= d) {
                    ans++;
                }
            }
        }

        List<Integer> v = new ArrayList<>();
        for (int lv : left) {
            if (lv + 1 <= d) {
                v.add(lv + 1);
            }
        }
        for (int rv : right) {
            if (rv + 1 <= d) {
                v.add(rv + 1);
            }
        }

        return v;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans;
    }
}
