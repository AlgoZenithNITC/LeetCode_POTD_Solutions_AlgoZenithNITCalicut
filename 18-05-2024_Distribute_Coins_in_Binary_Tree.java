/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int x) { val = x; }
 *     TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; }
 * }
 */
class Solution {
    public int giveCoins(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int left = giveCoins(root.left, ans);
        int right = giveCoins(root.right, ans);
        ans[0] += Math.abs(left) + Math.abs(right);
        return root.val + right + left - 1;
    }

    public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        giveCoins(root, ans);
        return ans[0];
    }
}

