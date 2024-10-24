/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;  // both roots are empty
        }
        if (root1 == null || root2 == null) {
            return false;  // either one of them is empty
        }
        if (root1.val != root2.val) {
            return false;  // nodes are not equal
        }
        
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);  // flip is happening
        boolean no_flip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);  // flip is not happening
        
        return flip || no_flip;
    }
}
